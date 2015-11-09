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
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.aj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatView extends CommonPersonalMsglistView {
    private View.OnClickListener aJd;
    private LinearLayout aZu;
    private View.OnClickListener bKm;
    private com.baidu.adp.lib.g.d bMD;
    private FloatingPersonalChatActivity bMU;
    private LinearLayout bMV;
    private h bMW;
    private h bMX;
    private h bMY;
    private h bMZ;
    private Runnable bMq;
    private boolean bNa;
    private boolean bNb;
    private boolean bNc;
    private aj.a bNd;
    private l bNe;
    private aj bNf;
    private a bNg;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* loaded from: classes.dex */
    public interface a {
        void delete(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ() {
        if (this.bMV != null) {
            this.bMV.removeCallbacks(this.bMq);
        }
        this.bMU.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().YH();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().dD(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().YC();
    }

    public void Zn() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.bNe.iG(userData.getUserName());
            this.bNe.hX(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().iE(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.bMU.hY(i);
            Zn();
            Zt();
            Zo();
        }
    }

    private void Zo() {
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
        this.bNa = false;
        this.bNb = false;
        this.bNc = false;
        this.aJd = new ac(this);
        this.bMq = new ad(this);
        this.bNd = new ae(this);
        this.bNg = new af(this);
        this.bMD = new ag(this);
        this.bKm = new ah(this);
        this.bMU = floatingPersonalChatActivity;
        this.aZu = (LinearLayout) floatingPersonalChatActivity.findViewById(i.f.view_header);
        getListMain().setBackgroundColor(this.bMU.getPageContext().getPageActivity().getResources().getColor(i.c.float_chat_list_background));
        this.bMV = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(i.f.floating_personal_chat_header_stub)).inflate();
        this.bMV.setOnClickListener(new ai(this));
        this.mUserDataList = this.bMU.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.bNf = new aj();
        this.bNf.a(this.bNd);
        this.bNf.a(floatingPersonalChatActivity);
        this.bNf.aV(this.mUserDataList);
        this.bMW = new h((RelativeLayout) this.bMV.findViewById(i.f.im_floating_head_first), 0);
        this.bMX = new h((RelativeLayout) this.bMV.findViewById(i.f.im_floating_head_second), 1);
        this.bMY = new h((RelativeLayout) this.bMV.findViewById(i.f.im_floating_head_third), 2);
        this.bMZ = new h((RelativeLayout) this.bMV.findViewById(i.f.im_floating_head_fourth), 3);
        this.bMW.setOnClickListener(this.aJd);
        this.bMX.setOnClickListener(this.aJd);
        this.bMY.setOnClickListener(this.aJd);
        this.bMZ.setOnClickListener(this.aJd);
        this.bMW.a(this.bNg);
        this.bMX.a(this.bNg);
        this.bMY.a(this.bNg);
        this.bMZ.a(this.bNg);
        this.bNe = new l(((ViewStub) floatingPersonalChatActivity.findViewById(i.f.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null) {
            int size = this.mUserDataList.size();
            if (this.currentIndex >= 0 && this.currentIndex < size) {
                userData = this.mUserDataList.get(this.currentIndex);
                if (userData != null) {
                    this.bNe.iG(userData.getUserName());
                    this.bNe.hX(this.bNf.c(userData));
                }
                Zt();
                if (this.bMV != null) {
                    this.bMV.post(this.bMq);
                }
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aZu.addView(createStateBarFillView(), 0);
                }
                if (userData == null) {
                    boolean iH = this.bNf.iH(userData.getUserId());
                    if (!Zq() && !iH && this.mTool != null) {
                        b(this.mTool.dS(6));
                        b(this.mTool.dS(2));
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
        Zt();
        if (this.bMV != null) {
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
        }
        if (userData == null) {
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.bMU.getPageContext().getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public void Zp() {
        this.bNa = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.bMZ.a((com.baidu.adp.lib.g.d) null);
            this.bMY.a((com.baidu.adp.lib.g.d) null);
            this.bMX.a((com.baidu.adp.lib.g.d) null);
            this.bMW.a((com.baidu.adp.lib.g.d) null);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.bKm);
        }
    }

    private boolean Zq() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean iH(String str) {
        return this.bNf.iH(str);
    }

    public void Zr() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.bNb) {
                    this.bNb = true;
                    AJ();
                }
            } else if (!this.bNc) {
                this.bMW.b(this.bMD);
                this.bMX.b((com.baidu.adp.lib.g.d) null);
                this.bMY.b((com.baidu.adp.lib.g.d) null);
                this.bMZ.b((com.baidu.adp.lib.g.d) null);
            }
        }
    }

    public void c(long j, int i) {
        this.bNf.R(String.valueOf(j), i);
        this.bNe.hX(this.bNf.iJ(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.bNe.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bNe.p(onClickListener);
    }

    public int iI(String str) {
        return this.bNf.iJ(str);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(i.c.floating_chat_bg);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().iB(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    c(data);
                }
                boolean Zu = Zu();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                Zs();
                if (this.bNa) {
                    Zt();
                    if (Zu) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        dF(z);
                    }
                }
            }
        }
    }

    private void Zs() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().iF(remove.getUserId());
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

    private void dF(boolean z) {
        if (!z) {
            this.bMW.Zj();
        }
        this.bMX.Zj();
        this.bMY.Zj();
        this.bMZ.Zj();
    }

    public void ia(int i) {
        if (i > 0) {
            this.bMW.Zk();
        }
        if (i > 1) {
            this.bMX.Zk();
        }
        if (i > 2) {
            this.bMY.Zk();
        }
    }

    public void Zt() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().P(userData.getPortrait(), userData.getConcern_num());
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
                this.bMW.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.bMX.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.bMY.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.bMZ.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean Zu() {
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
                            this.bNf.R(userData3.getUserId(), 1);
                        } else {
                            this.bNf.R(userData3.getUserId(), 0);
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
            PersonalSettingItemData aJ = com.baidu.tieba.im.settingcache.j.XA().aJ(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (aJ != null) {
                buildNormalItem.setGroupSetting(aJ);
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
