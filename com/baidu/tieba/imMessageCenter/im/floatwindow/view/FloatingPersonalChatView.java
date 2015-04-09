package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatView extends CommonPersonalMsglistView {
    private View.OnClickListener aBz;
    private Runnable atI;
    private com.baidu.adp.lib.g.e brI;
    private FloatingPersonalChatActivity brZ;
    private LinearLayout bsa;
    private i bsb;
    private i bsc;
    private i bsd;
    private i bse;
    private boolean bsf;
    private boolean bsg;
    private boolean bsh;
    private ar bsi;
    private n bsj;
    private ap bsk;
    private ao bsl;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        if (this.bsa != null) {
            this.bsa.removeCallbacks(this.atI);
        }
        this.brZ.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().UH();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().dh(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().UC();
    }

    public void Vn() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.bsj.hl(userData.getUserName());
            this.bsj.gz(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().hj(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.brZ.gA(i);
            Vn();
            Vt();
            Vo();
        }
    }

    private void Vo() {
        sendGovoiceEvent();
        sendmsgShowText();
        afterSendMsgText();
    }

    public FloatingPersonalChatView(FloatingPersonalChatActivity floatingPersonalChatActivity, boolean z, List<UserData> list) {
        super(floatingPersonalChatActivity, z);
        this.mList = new LinkedList<>();
        this.mUserDataList = null;
        this.bsf = false;
        this.bsg = false;
        this.bsh = false;
        this.aBz = new ae(this);
        this.atI = new ag(this);
        this.bsi = new ah(this);
        this.bsl = new ai(this);
        this.brI = new aj(this);
        this.brZ = floatingPersonalChatActivity;
        getListMain().setBackgroundColor(this.brZ.getPageContext().getPageActivity().getResources().getColor(com.baidu.tieba.s.float_chat_list_background));
        this.bsa = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.v.floating_personal_chat_header_stub)).inflate();
        this.bsa.setOnClickListener(new ak(this));
        this.mUserDataList = this.brZ.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.bsk = new ap();
        this.bsk.a(this.bsi);
        this.bsk.a(floatingPersonalChatActivity);
        this.bsk.aM(this.mUserDataList);
        this.bsb = new i((RelativeLayout) this.bsa.findViewById(com.baidu.tieba.v.im_floating_head_first), 0);
        this.bsc = new i((RelativeLayout) this.bsa.findViewById(com.baidu.tieba.v.im_floating_head_second), 1);
        this.bsd = new i((RelativeLayout) this.bsa.findViewById(com.baidu.tieba.v.im_floating_head_third), 2);
        this.bse = new i((RelativeLayout) this.bsa.findViewById(com.baidu.tieba.v.im_floating_head_fourth), 3);
        this.bsb.setOnClickListener(this.aBz);
        this.bsc.setOnClickListener(this.aBz);
        this.bsd.setOnClickListener(this.aBz);
        this.bse.setOnClickListener(this.aBz);
        this.bsb.a(this.bsl);
        this.bsc.a(this.bsl);
        this.bsd.a(this.bsl);
        this.bse.a(this.bsl);
        this.bsj = new n(((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.v.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null && this.mUserDataList.get(this.currentIndex) != null) {
            this.bsj.hl(this.mUserDataList.get(this.currentIndex).getUserName());
        }
        if (this.mUserDataList != null) {
            this.bsj.gz(this.bsk.c(this.mUserDataList.get(this.currentIndex)));
        }
        Vt();
        if (this.bsa != null) {
            this.bsa.post(this.atI);
        }
    }

    public void Vp() {
        this.bsf = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.bse.a((com.baidu.adp.lib.g.e) null);
            this.bsd.a((com.baidu.adp.lib.g.e) null);
            this.bsc.a((com.baidu.adp.lib.g.e) null);
            this.bsb.a((com.baidu.adp.lib.g.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgsendVoice(MsglistActivity msglistActivity) {
        super.initMsgsendVoice(msglistActivity);
        this.mBtnMsgSendSoftkey.setOnClickListener(new al(this));
        this.mBtnMsgSendMore1.setOnClickListener(new am(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgsendText(TalkableActivity talkableActivity) {
        super.initMsgsendText(talkableActivity);
        this.mBtnMsgSendGovoice.setOnClickListener(new an(this));
        this.mBtnMsgSendMore2.setOnClickListener(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vq() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean hm(String str) {
        return this.bsk.hm(str);
    }

    public void Vr() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.bsg) {
                    this.bsg = true;
                    exit();
                }
            } else if (!this.bsh) {
                this.bsb.b(this.brI);
                this.bsc.b((com.baidu.adp.lib.g.e) null);
                this.bsd.b((com.baidu.adp.lib.g.e) null);
                this.bse.b((com.baidu.adp.lib.g.e) null);
            }
        }
    }

    public void c(long j, int i) {
        this.bsk.L(String.valueOf(j), i);
        this.bsj.gz(this.bsk.ho(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.bsj.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bsj.r(onClickListener);
    }

    public int hn(String str) {
        return this.bsk.ho(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(com.baidu.tieba.s.floating_chat_bg);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().hg(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    a(data);
                }
                boolean Vu = Vu();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                Vs();
                if (this.bsf) {
                    Vt();
                    if (Vu) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        dj(z);
                    }
                }
            }
        }
    }

    private void Vs() {
        int i;
        if (this.mUserDataList != null && this.mUserDataList.size() > 4) {
            if (this.currentIndex == 0) {
                i = 1;
            } else {
                this.currentIndex--;
                i = 0;
            }
            while (this.mUserDataList.size() > 4) {
                UserData remove = this.mUserDataList.remove(i);
                if (remove != null) {
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().hk(remove.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(remove.getUserId(), next.getFriendId())) {
                            this.mList.remove(next);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void dj(boolean z) {
        if (!z) {
            this.bsb.Vj();
        }
        this.bsc.Vj();
        this.bsd.Vj();
        this.bse.Vj();
    }

    public void gC(int i) {
        if (i > 0) {
            this.bsb.Vk();
        }
        if (i > 1) {
            this.bsc.Vk();
        }
        if (i > 2) {
            this.bsd.Vk();
        }
    }

    public void Vt() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy().J(userData.getPortrait(), userData.getConcern_num());
                        a(i, true, userData);
                    }
                } else {
                    a(i, false, null);
                }
                i++;
            }
        }
    }

    private void a(int i, boolean z, UserData userData) {
        switch (i) {
            case 0:
                this.bsb.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.bsc.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.bsd.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.bse.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean Vu() {
        if (this.mUserDataList == null) {
            return false;
        }
        int size = this.mUserDataList.size();
        UserData userData = this.mUserDataList.get(this.currentIndex);
        if (userData != null) {
            for (int i = 0; i < this.mList.size(); i++) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i);
                if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getUnReadCount() > 0 && !imMessageCenterShowItemData.getFriendId().equals(userData.getUserId())) {
                    int index = getIndex(imMessageCenterShowItemData.getFriendId());
                    if (index != -1) {
                        UserData userData2 = this.mUserDataList.get(index);
                        if (userData2 != null) {
                            userData2.setConcern_num(imMessageCenterShowItemData.getUnReadCount());
                        }
                    } else {
                        UserData userData3 = new UserData();
                        userData3.setUserId(imMessageCenterShowItemData.getFriendId());
                        userData3.setPortrait(imMessageCenterShowItemData.getFriendPortrait());
                        userData3.setConcern_num(imMessageCenterShowItemData.getUnReadCount());
                        userData3.setIsFriend(imMessageCenterShowItemData.getFriendStatus());
                        if (imMessageCenterShowItemData.getFriendStatus() == 1) {
                            this.bsk.L(userData3.getUserId(), 1);
                        } else {
                            this.bsk.L(userData3.getUserId(), 0);
                        }
                        userData3.setUserName(imMessageCenterShowItemData.getFriendName());
                        this.mUserDataList.add(userData3);
                    }
                }
            }
            return this.mUserDataList.size() - size > 0;
        }
        return false;
    }

    private int getIndex(String str) {
        if (this.mUserDataList == null || this.mUserDataList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mUserDataList.size()) {
                return -1;
            }
            if (this.mUserDataList.get(i2) == null || !TextUtils.equals(this.mUserDataList.get(i2).getUserId(), str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && isNeed(imMessageCenterPojo)) {
            ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
            if (isNeed(imMessageCenterPojo) && imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, removeItem);
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(4));
            PersonalSettingItemData aE = com.baidu.tieba.im.settingcache.j.TD().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (aE != null) {
                buildNormalItem.setGroupSetting(aE);
            }
            buildNormalItem.setFriendStatus(imMessageCenterPojo.getIsFriend());
            insertShowData(buildNormalItem, this.mList);
        }
    }

    protected void insertShowData(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
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

    protected ImMessageCenterShowItemData buildNormalItem(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
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
        imMessageCenterShowItemData.setOwnerId(TbadkCoreApplication.getCurrentAccount());
        imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
        imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
        imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
        imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
        if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
            imMessageCenterPojo.setLast_content("");
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
        return imMessageCenterShowItemData;
    }

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2 || imMessageCenterPojo.getIsFriend() != 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }

    private ImMessageCenterShowItemData removeItem(ImMessageCenterPojo imMessageCenterPojo) {
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i);
            if (imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData.getFriendId()) && imMessageCenterPojo.getCustomGroupType() == getCustomGroupType(imMessageCenterShowItemData)) {
                return this.mList.remove(i);
            }
        }
        return null;
    }

    private int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
            return 1;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
            return -3;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
            return -4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(6))) {
            return -5;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
            return -8;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(8))) {
            return 4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
            return 2;
        }
        if (!imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
            return 0;
        }
        return -7;
    }
}
