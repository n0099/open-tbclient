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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatView extends CommonPersonalMsglistView {
    private LinearLayout bcK;
    private View.OnClickListener bgP;
    private com.baidu.adp.lib.h.d cIF;
    private int currentIndex;
    private View.OnClickListener dut;
    private Runnable dww;
    private FloatingPersonalChatActivity dxa;
    private LinearLayout dxb;
    private h dxc;
    private h dxd;
    private h dxe;
    private h dxf;
    private boolean dxg;
    private boolean dxh;
    private boolean dxi;
    private aj.a dxj;
    private l dxk;
    private aj dxl;
    private a dxm;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* loaded from: classes.dex */
    public interface a {
        void delete(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc() {
        if (this.dxb != null) {
            this.dxb.removeCallbacks(this.dww);
        }
        this.dxa.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().azR();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().gN(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().azM();
    }

    public void aAw() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.dxk.mN(userData.getUserName());
            this.dxk.mt(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mK(this.mUserDataList.get(i).getUserId());
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mL(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.dxa.mu(i);
            aAw();
            aAC();
            aAx();
        }
    }

    private void aAx() {
        afterSendMsgText();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingPersonalChatView(FloatingPersonalChatActivity floatingPersonalChatActivity, boolean z, List<UserData> list) {
        super(floatingPersonalChatActivity, z);
        UserData userData;
        this.mList = new LinkedList<>();
        this.mUserDataList = null;
        this.dxg = false;
        this.dxh = false;
        this.dxi = false;
        this.bgP = new ac(this);
        this.dww = new ad(this);
        this.dxj = new ae(this);
        this.dxm = new af(this);
        this.cIF = new ag(this);
        this.dut = new ah(this);
        this.dxa = floatingPersonalChatActivity;
        this.bcK = (LinearLayout) floatingPersonalChatActivity.findViewById(r.g.view_header);
        getListMain().setBackgroundColor(this.dxa.getPageContext().getPageActivity().getResources().getColor(r.d.cp_bg_line_c));
        this.dxb = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(r.g.floating_personal_chat_header_stub)).inflate();
        this.dxb.setOnClickListener(new ai(this));
        this.mUserDataList = this.dxa.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.dxl = new aj();
        this.dxl.a(this.dxj);
        this.dxl.a(floatingPersonalChatActivity);
        this.dxl.bZ(this.mUserDataList);
        this.dxc = new h((RelativeLayout) this.dxb.findViewById(r.g.im_floating_head_first), 0);
        this.dxd = new h((RelativeLayout) this.dxb.findViewById(r.g.im_floating_head_second), 1);
        this.dxe = new h((RelativeLayout) this.dxb.findViewById(r.g.im_floating_head_third), 2);
        this.dxf = new h((RelativeLayout) this.dxb.findViewById(r.g.im_floating_head_fourth), 3);
        this.dxc.setOnClickListener(this.bgP);
        this.dxd.setOnClickListener(this.bgP);
        this.dxe.setOnClickListener(this.bgP);
        this.dxf.setOnClickListener(this.bgP);
        this.dxc.a(this.dxm);
        this.dxd.a(this.dxm);
        this.dxe.a(this.dxm);
        this.dxf.a(this.dxm);
        this.dxk = new l(((ViewStub) floatingPersonalChatActivity.findViewById(r.g.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null) {
            int size = this.mUserDataList.size();
            if (this.currentIndex >= 0 && this.currentIndex < size) {
                userData = this.mUserDataList.get(this.currentIndex);
                if (userData != null) {
                    this.dxk.mN(userData.getUserName());
                    this.dxk.mt(this.dxl.c(userData));
                }
                aAC();
                if (this.dxb != null) {
                    this.dxb.post(this.dww);
                }
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bcK.addView(createStateBarFillView(), 0);
                }
                if (userData == null) {
                    boolean mO = this.dxl.mO(userData.getUserId());
                    if (!aAz() && !mO && this.mTool != null) {
                        b(this.mTool.ez(6));
                        b(this.mTool.ez(2));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        userData = null;
        if (userData != null) {
        }
        aAC();
        if (this.dxb != null) {
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
        }
        if (userData == null) {
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.dxa.getPageContext().getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public void aAy() {
        this.dxg = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.dxf.a((com.baidu.adp.lib.h.d) null);
            this.dxe.a((com.baidu.adp.lib.h.d) null);
            this.dxd.a((com.baidu.adp.lib.h.d) null);
            this.dxc.a((com.baidu.adp.lib.h.d) null);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.dut);
        }
    }

    private boolean aAz() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean mO(String str) {
        return this.dxl.mO(str);
    }

    public void aAA() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.dxh) {
                    this.dxh = true;
                    Dc();
                }
            } else if (!this.dxi) {
                this.dxc.b(this.cIF);
                this.dxd.b((com.baidu.adp.lib.h.d) null);
                this.dxe.b((com.baidu.adp.lib.h.d) null);
                this.dxf.b((com.baidu.adp.lib.h.d) null);
            }
        }
    }

    public void k(long j, int i) {
        this.dxl.ap(String.valueOf(j), i);
        this.dxk.mt(this.dxl.mQ(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.dxk.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dxk.q(onClickListener);
    }

    public int mP(String str) {
        return this.dxl.mQ(str);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(r.d.common_color_10065);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mH(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    c(data);
                }
                boolean aAD = aAD();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                aAB();
                if (this.dxg) {
                    aAC();
                    if (aAD) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        gP(z);
                    }
                }
            }
        }
    }

    private void aAB() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mM(remove.getUserId());
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

    private void gP(boolean z) {
        if (!z) {
            this.dxc.aAs();
        }
        this.dxd.aAs();
        this.dxe.aAs();
        this.dxf.aAs();
    }

    public void mw(int i) {
        if (i > 0) {
            this.dxc.aAt();
        }
        if (i > 1) {
            this.dxd.aAt();
        }
        if (i > 2) {
            this.dxe.aAt();
        }
    }

    public void aAC() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().an(userData.getPortrait(), userData.getConcern_num());
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
                this.dxc.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.dxd.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.dxe.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.dxf.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean aAD() {
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
                            this.dxl.ap(userData3.getUserId(), 1);
                        } else {
                            this.dxl.ap(userData3.getUserId(), 0);
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

    private void c(ImMessageCenterPojo imMessageCenterPojo) {
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
            PersonalSettingItemData bj = com.baidu.tieba.im.settingcache.j.ayG().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (bj != null) {
                buildNormalItem.setGroupSetting(bj);
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
