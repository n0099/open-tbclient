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
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatView extends CommonPersonalMsglistView {
    private View.OnClickListener aNE;
    private View.OnClickListener bZr;
    private LinearLayout bfy;
    private com.baidu.adp.lib.h.d cbH;
    private FloatingPersonalChatActivity cbY;
    private LinearLayout cbZ;
    private Runnable cbu;
    private h cca;
    private h ccb;
    private h ccc;
    private h ccd;
    private boolean cce;
    private boolean ccf;
    private boolean ccg;
    private aj.a cch;
    private l cci;
    private aj ccj;
    private a cck;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* loaded from: classes.dex */
    public interface a {
        void delete(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        if (this.cbZ != null) {
            this.cbZ.removeCallbacks(this.cbu);
        }
        this.cbY.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().abN();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().dY(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().abI();
    }

    public void act() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.cci.ja(userData.getUserName());
            this.cci.iL(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iN(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().iY(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.cbY.iM(i);
            act();
            acz();
            acu();
        }
    }

    private void acu() {
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
        this.cce = false;
        this.ccf = false;
        this.ccg = false;
        this.aNE = new ac(this);
        this.cbu = new ad(this);
        this.cch = new ae(this);
        this.cck = new af(this);
        this.cbH = new ag(this);
        this.bZr = new ah(this);
        this.cbY = floatingPersonalChatActivity;
        this.bfy = (LinearLayout) floatingPersonalChatActivity.findViewById(n.f.view_header);
        getListMain().setBackgroundColor(this.cbY.getPageContext().getPageActivity().getResources().getColor(n.c.float_chat_list_background));
        this.cbZ = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(n.f.floating_personal_chat_header_stub)).inflate();
        this.cbZ.setOnClickListener(new ai(this));
        this.mUserDataList = this.cbY.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.ccj = new aj();
        this.ccj.a(this.cch);
        this.ccj.a(floatingPersonalChatActivity);
        this.ccj.bg(this.mUserDataList);
        this.cca = new h((RelativeLayout) this.cbZ.findViewById(n.f.im_floating_head_first), 0);
        this.ccb = new h((RelativeLayout) this.cbZ.findViewById(n.f.im_floating_head_second), 1);
        this.ccc = new h((RelativeLayout) this.cbZ.findViewById(n.f.im_floating_head_third), 2);
        this.ccd = new h((RelativeLayout) this.cbZ.findViewById(n.f.im_floating_head_fourth), 3);
        this.cca.setOnClickListener(this.aNE);
        this.ccb.setOnClickListener(this.aNE);
        this.ccc.setOnClickListener(this.aNE);
        this.ccd.setOnClickListener(this.aNE);
        this.cca.a(this.cck);
        this.ccb.a(this.cck);
        this.ccc.a(this.cck);
        this.ccd.a(this.cck);
        this.cci = new l(((ViewStub) floatingPersonalChatActivity.findViewById(n.f.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null) {
            int size = this.mUserDataList.size();
            if (this.currentIndex >= 0 && this.currentIndex < size) {
                userData = this.mUserDataList.get(this.currentIndex);
                if (userData != null) {
                    this.cci.ja(userData.getUserName());
                    this.cci.iL(this.ccj.c(userData));
                }
                acz();
                if (this.cbZ != null) {
                    this.cbZ.post(this.cbu);
                }
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bfy.addView(createStateBarFillView(), 0);
                }
                if (userData == null) {
                    boolean jb = this.ccj.jb(userData.getUserId());
                    if (!acw() && !jb && this.mTool != null) {
                        b(this.mTool.eg(6));
                        b(this.mTool.eg(2));
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
        acz();
        if (this.cbZ != null) {
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
        }
        if (userData == null) {
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.cbY.getPageContext().getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public void acv() {
        this.cce = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.ccd.a((com.baidu.adp.lib.h.d) null);
            this.ccc.a((com.baidu.adp.lib.h.d) null);
            this.ccb.a((com.baidu.adp.lib.h.d) null);
            this.cca.a((com.baidu.adp.lib.h.d) null);
        }
    }

    private void b(com.baidu.tbadk.editortools.r rVar) {
        if (rVar != null && rVar != null && (rVar instanceof View)) {
            ((View) rVar).setOnClickListener(this.bZr);
        }
    }

    private boolean acw() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean jb(String str) {
        return this.ccj.jb(str);
    }

    public void acx() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.ccf) {
                    this.ccf = true;
                    BH();
                }
            } else if (!this.ccg) {
                this.cca.b(this.cbH);
                this.ccb.b((com.baidu.adp.lib.h.d) null);
                this.ccc.b((com.baidu.adp.lib.h.d) null);
                this.ccd.b((com.baidu.adp.lib.h.d) null);
            }
        }
    }

    public void c(long j, int i) {
        this.ccj.W(String.valueOf(j), i);
        this.cci.iL(this.ccj.jd(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.cci.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cci.p(onClickListener);
    }

    public int jc(String str) {
        return this.ccj.jd(str);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(n.c.floating_chat_bg);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().iV(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    c(data);
                }
                boolean acA = acA();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                acy();
                if (this.cce) {
                    acz();
                    if (acA) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        ea(z);
                    }
                }
            }
        }
    }

    private void acy() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().iZ(remove.getUserId());
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

    private void ea(boolean z) {
        if (!z) {
            this.cca.acp();
        }
        this.ccb.acp();
        this.ccc.acp();
        this.ccd.acp();
    }

    public void iO(int i) {
        if (i > 0) {
            this.cca.acq();
        }
        if (i > 1) {
            this.ccb.acq();
        }
        if (i > 2) {
            this.ccc.acq();
        }
    }

    public void acz() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().U(userData.getPortrait(), userData.getConcern_num());
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
                this.cca.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.ccb.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.ccc.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.ccd.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean acA() {
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
                            this.ccj.W(userData3.getUserId(), 1);
                        } else {
                            this.ccj.W(userData3.getUserId(), 0);
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
            PersonalSettingItemData aO = com.baidu.tieba.im.settingcache.j.aaG().aO(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (aO != null) {
                buildNormalItem.setGroupSetting(aO);
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
