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
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatView extends CommonPersonalMsglistView {
    private LinearLayout aZg;
    private View.OnClickListener bdv;
    private com.baidu.adp.lib.h.d cCN;
    private int currentIndex;
    private View.OnClickListener dnn;
    private FloatingPersonalChatActivity dpW;
    private LinearLayout dpX;
    private h dpY;
    private h dpZ;
    private Runnable dps;
    private h dqa;
    private h dqb;
    private boolean dqc;
    private boolean dqd;
    private boolean dqe;
    private aj.a dqf;
    private l dqg;
    private aj dqh;
    private a dqi;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* loaded from: classes.dex */
    public interface a {
        void delete(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU() {
        if (this.dpX != null) {
            this.dpX.removeCallbacks(this.dps);
        }
        this.dpW.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().axv();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().gq(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().axq();
    }

    public void ayb() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.dqg.mn(userData.getUserName());
            this.dqg.md(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().mk(this.mUserDataList.get(i).getUserId());
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().ml(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.dpW.me(i);
            ayb();
            ayh();
            ayc();
        }
    }

    private void ayc() {
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
        this.dqc = false;
        this.dqd = false;
        this.dqe = false;
        this.bdv = new ac(this);
        this.dps = new ad(this);
        this.dqf = new ae(this);
        this.dqi = new af(this);
        this.cCN = new ag(this);
        this.dnn = new ah(this);
        this.dpW = floatingPersonalChatActivity;
        this.aZg = (LinearLayout) floatingPersonalChatActivity.findViewById(t.g.view_header);
        getListMain().setBackgroundColor(this.dpW.getPageContext().getPageActivity().getResources().getColor(t.d.cp_bg_line_c));
        this.dpX = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(t.g.floating_personal_chat_header_stub)).inflate();
        this.dpX.setOnClickListener(new ai(this));
        this.mUserDataList = this.dpW.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.dqh = new aj();
        this.dqh.a(this.dqf);
        this.dqh.a(floatingPersonalChatActivity);
        this.dqh.bW(this.mUserDataList);
        this.dpY = new h((RelativeLayout) this.dpX.findViewById(t.g.im_floating_head_first), 0);
        this.dpZ = new h((RelativeLayout) this.dpX.findViewById(t.g.im_floating_head_second), 1);
        this.dqa = new h((RelativeLayout) this.dpX.findViewById(t.g.im_floating_head_third), 2);
        this.dqb = new h((RelativeLayout) this.dpX.findViewById(t.g.im_floating_head_fourth), 3);
        this.dpY.setOnClickListener(this.bdv);
        this.dpZ.setOnClickListener(this.bdv);
        this.dqa.setOnClickListener(this.bdv);
        this.dqb.setOnClickListener(this.bdv);
        this.dpY.a(this.dqi);
        this.dpZ.a(this.dqi);
        this.dqa.a(this.dqi);
        this.dqb.a(this.dqi);
        this.dqg = new l(((ViewStub) floatingPersonalChatActivity.findViewById(t.g.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null) {
            int size = this.mUserDataList.size();
            if (this.currentIndex >= 0 && this.currentIndex < size) {
                userData = this.mUserDataList.get(this.currentIndex);
                if (userData != null) {
                    this.dqg.mn(userData.getUserName());
                    this.dqg.md(this.dqh.c(userData));
                }
                ayh();
                if (this.dpX != null) {
                    this.dpX.post(this.dps);
                }
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aZg.addView(createStateBarFillView(), 0);
                }
                if (userData == null) {
                    boolean mo = this.dqh.mo(userData.getUserId());
                    if (!aye() && !mo && this.mTool != null) {
                        b(this.mTool.ex(6));
                        b(this.mTool.ex(2));
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
        ayh();
        if (this.dpX != null) {
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
        }
        if (userData == null) {
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.dpW.getPageContext().getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public void ayd() {
        this.dqc = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.dqb.a((com.baidu.adp.lib.h.d) null);
            this.dqa.a((com.baidu.adp.lib.h.d) null);
            this.dpZ.a((com.baidu.adp.lib.h.d) null);
            this.dpY.a((com.baidu.adp.lib.h.d) null);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.dnn);
        }
    }

    private boolean aye() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean mo(String str) {
        return this.dqh.mo(str);
    }

    public void ayf() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.dqd) {
                    this.dqd = true;
                    CU();
                }
            } else if (!this.dqe) {
                this.dpY.b(this.cCN);
                this.dpZ.b((com.baidu.adp.lib.h.d) null);
                this.dqa.b((com.baidu.adp.lib.h.d) null);
                this.dqb.b((com.baidu.adp.lib.h.d) null);
            }
        }
    }

    public void k(long j, int i) {
        this.dqh.ap(String.valueOf(j), i);
        this.dqg.md(this.dqh.mq(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.dqg.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dqg.p(onClickListener);
    }

    public int mp(String str) {
        return this.dqh.mq(str);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(t.d.common_color_10065);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().mh(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    c(data);
                }
                boolean ayi = ayi();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                ayg();
                if (this.dqc) {
                    ayh();
                    if (ayi) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        gs(z);
                    }
                }
            }
        }
    }

    private void ayg() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().mm(remove.getUserId());
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

    private void gs(boolean z) {
        if (!z) {
            this.dpY.axX();
        }
        this.dpZ.axX();
        this.dqa.axX();
        this.dqb.axX();
    }

    public void mg(int i) {
        if (i > 0) {
            this.dpY.axY();
        }
        if (i > 1) {
            this.dpZ.axY();
        }
        if (i > 2) {
            this.dqa.axY();
        }
    }

    public void ayh() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().an(userData.getPortrait(), userData.getConcern_num());
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
                this.dpY.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.dpZ.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.dqa.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.dqb.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean ayi() {
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
                            this.dqh.ap(userData3.getUserId(), 1);
                        } else {
                            this.dqh.ap(userData3.getUserId(), 0);
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
            PersonalSettingItemData bh = com.baidu.tieba.im.settingcache.j.awk().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (bh != null) {
                buildNormalItem.setGroupSetting(bh);
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
