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
    private View.OnClickListener aBr;
    private Runnable atA;
    private FloatingPersonalChatActivity brJ;
    private LinearLayout brK;
    private i brL;
    private i brM;
    private i brN;
    private i brO;
    private boolean brP;
    private boolean brQ;
    private boolean brR;
    private ar brS;
    private n brT;
    private ap brU;
    private ao brV;
    private com.baidu.adp.lib.g.e brs;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        if (this.brK != null) {
            this.brK.removeCallbacks(this.atA);
        }
        this.brJ.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().Uu();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().dj(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().Up();
    }

    public void Va() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.brT.hi(userData.getUserName());
            this.brT.gx(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().hg(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.brJ.gy(i);
            Va();
            Vg();
            Vb();
        }
    }

    private void Vb() {
        sendGovoiceEvent();
        sendmsgShowText();
        afterSendMsgText();
    }

    public FloatingPersonalChatView(FloatingPersonalChatActivity floatingPersonalChatActivity, boolean z, List<UserData> list) {
        super(floatingPersonalChatActivity, z);
        this.mList = new LinkedList<>();
        this.mUserDataList = null;
        this.brP = false;
        this.brQ = false;
        this.brR = false;
        this.aBr = new ae(this);
        this.atA = new ag(this);
        this.brS = new ah(this);
        this.brV = new ai(this);
        this.brs = new aj(this);
        this.brJ = floatingPersonalChatActivity;
        getListMain().setBackgroundColor(this.brJ.getPageContext().getPageActivity().getResources().getColor(com.baidu.tieba.s.float_chat_list_background));
        this.brK = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.v.floating_personal_chat_header_stub)).inflate();
        this.brK.setOnClickListener(new ak(this));
        this.mUserDataList = this.brJ.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.brU = new ap();
        this.brU.a(this.brS);
        this.brU.a(floatingPersonalChatActivity);
        this.brU.aK(this.mUserDataList);
        this.brL = new i((RelativeLayout) this.brK.findViewById(com.baidu.tieba.v.im_floating_head_first), 0);
        this.brM = new i((RelativeLayout) this.brK.findViewById(com.baidu.tieba.v.im_floating_head_second), 1);
        this.brN = new i((RelativeLayout) this.brK.findViewById(com.baidu.tieba.v.im_floating_head_third), 2);
        this.brO = new i((RelativeLayout) this.brK.findViewById(com.baidu.tieba.v.im_floating_head_fourth), 3);
        this.brL.setOnClickListener(this.aBr);
        this.brM.setOnClickListener(this.aBr);
        this.brN.setOnClickListener(this.aBr);
        this.brO.setOnClickListener(this.aBr);
        this.brL.a(this.brV);
        this.brM.a(this.brV);
        this.brN.a(this.brV);
        this.brO.a(this.brV);
        this.brT = new n(((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.v.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null && this.mUserDataList.get(this.currentIndex) != null) {
            this.brT.hi(this.mUserDataList.get(this.currentIndex).getUserName());
        }
        if (this.mUserDataList != null) {
            this.brT.gx(this.brU.c(this.mUserDataList.get(this.currentIndex)));
        }
        Vg();
        if (this.brK != null) {
            this.brK.post(this.atA);
        }
    }

    public void Vc() {
        this.brP = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.brO.a((com.baidu.adp.lib.g.e) null);
            this.brN.a((com.baidu.adp.lib.g.e) null);
            this.brM.a((com.baidu.adp.lib.g.e) null);
            this.brL.a((com.baidu.adp.lib.g.e) null);
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
    public boolean Vd() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean hj(String str) {
        return this.brU.hj(str);
    }

    public void Ve() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.brQ) {
                    this.brQ = true;
                    exit();
                }
            } else if (!this.brR) {
                this.brL.b(this.brs);
                this.brM.b((com.baidu.adp.lib.g.e) null);
                this.brN.b((com.baidu.adp.lib.g.e) null);
                this.brO.b((com.baidu.adp.lib.g.e) null);
            }
        }
    }

    public void c(long j, int i) {
        this.brU.L(String.valueOf(j), i);
        this.brT.gx(this.brU.hl(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.brT.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.brT.q(onClickListener);
    }

    public int hk(String str) {
        return this.brU.hl(str);
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
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().hd(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    a(data);
                }
                boolean Vh = Vh();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                Vf();
                if (this.brP) {
                    Vg();
                    if (Vh) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        dl(z);
                    }
                }
            }
        }
    }

    private void Vf() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().hh(remove.getUserId());
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

    private void dl(boolean z) {
        if (!z) {
            this.brL.UW();
        }
        this.brM.UW();
        this.brN.UW();
        this.brO.UW();
    }

    public void gA(int i) {
        if (i > 0) {
            this.brL.UX();
        }
        if (i > 1) {
            this.brM.UX();
        }
        if (i > 2) {
            this.brN.UX();
        }
    }

    public void Vg() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().J(userData.getPortrait(), userData.getConcern_num());
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
                this.brL.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.brM.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.brN.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.brO.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean Vh() {
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
                            this.brU.L(userData3.getUserId(), 1);
                        } else {
                            this.brU.L(userData3.getUserId(), 0);
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
            PersonalSettingItemData aE = com.baidu.tieba.im.settingcache.j.Tq().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
