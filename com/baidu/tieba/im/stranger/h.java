package com.baidu.tieba.im.stranger;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final LinkedList<ImMessageCenterShowItemData> a = new LinkedList<>();

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.chat.notify.a aVar) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                Iterator<ImMessageCenterShowItemData> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ImMessageCenterShowItemData next = it.next();
                    if (next != null && friendId.equals(next.getFriendId())) {
                        this.a.remove(next);
                        break;
                    }
                }
                if (aVar != null) {
                    aVar.a();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new com.baidu.tieba.im.message.h(friendId, 2, false)));
            }
        }
    }

    private ImMessageCenterShowItemData a(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo == null) {
            return null;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() == 0) {
            return null;
        }
        if (imMessageCenterShowItemData == null) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        }
        imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
        imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
        imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
        imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
        imMessageCenterShowItemData.setSendStatus(imMessageCenterPojo.getSend_status());
        if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
            imMessageCenterPojo.setLast_content("");
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
        return imMessageCenterShowItemData;
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tieba.im.chat.notify.a aVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && imMessageCenterPojo.getCustomGroupType() == 2) {
            int size = this.a.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    imMessageCenterShowItemData = null;
                    break;
                } else if (!imMessageCenterPojo.getGid().equals(this.a.get(i).getFriendId())) {
                    i++;
                } else {
                    imMessageCenterShowItemData = this.a.remove(i);
                    break;
                }
            }
            b(imMessageCenterPojo, imMessageCenterShowItemData);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tieba.im.chat.notify.a aVar) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && imMessageCenterPojo.getCustomGroupType() == 2) {
            int size = this.a.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (!imMessageCenterPojo.getGid().equals(this.a.get(i).getFriendId())) {
                    i++;
                } else {
                    this.a.remove(i);
                    break;
                }
            }
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(List<ImMessageCenterPojo> list, com.baidu.tieba.im.chat.notify.a aVar) {
        this.a.clear();
        if (list == null) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : list) {
            if (a(imMessageCenterPojo)) {
                b(imMessageCenterPojo, (ImMessageCenterShowItemData) null);
            }
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData a;
        if (a(imMessageCenterPojo) && (a = a(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
            a.setSendStatus(imMessageCenterPojo.getSend_status());
            PersonalSettingItemData b = com.baidu.tieba.im.chat.personaltalk.a.a().b(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (b != null) {
                a.setGroupSetting(b);
            }
            a(a, this.a);
        }
    }

    private boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        return imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 0;
    }

    public LinkedList<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public void b() {
        LinkedList linkedList = new LinkedList();
        Iterator<ImMessageCenterShowItemData> it = this.a.iterator();
        while (it.hasNext()) {
            String friendId = it.next().getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                linkedList.add(new com.baidu.tieba.im.message.h(friendId, 2, false));
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearStrangerItemsMessage(new com.baidu.tieba.im.message.e(linkedList), true));
        this.a.clear();
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        if (imMessageCenterShowItemData != null && list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                ImMessageCenterShowItemData imMessageCenterShowItemData2 = list.get(i);
                if (imMessageCenterShowItemData2 != null && imMessageCenterShowItemData2.getServerTime() < imMessageCenterShowItemData.getServerTime()) {
                    break;
                }
                i++;
            }
            list.add(i, imMessageCenterShowItemData);
        }
    }
}
