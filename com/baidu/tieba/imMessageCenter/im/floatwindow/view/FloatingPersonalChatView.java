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
    private LinearLayout aTs;
    private View.OnClickListener aXp;
    private View.OnClickListener csv;
    private com.baidu.adp.lib.h.d cuN;
    private int currentIndex;
    private Runnable cuz;
    private FloatingPersonalChatActivity cve;
    private LinearLayout cvf;
    private h cvg;
    private h cvh;
    private h cvi;
    private h cvj;
    private boolean cvk;
    private boolean cvl;
    private boolean cvm;
    private aj.a cvn;
    private l cvo;
    private aj cvp;
    private a cvq;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* loaded from: classes.dex */
    public interface a {
        void delete(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dv() {
        if (this.cvf != null) {
            this.cvf.removeCallbacks(this.cuz);
        }
        this.cve.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().ajz();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().eB(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().aju();
    }

    public void akf() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.cvo.kb(userData.getUserName());
            this.cvo.ko(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().jY(this.mUserDataList.get(i).getUserId());
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().jZ(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.cve.kp(i);
            akf();
            akl();
            akg();
        }
    }

    private void akg() {
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
        this.cvk = false;
        this.cvl = false;
        this.cvm = false;
        this.aXp = new ac(this);
        this.cuz = new ad(this);
        this.cvn = new ae(this);
        this.cvq = new af(this);
        this.cuN = new ag(this);
        this.csv = new ah(this);
        this.cve = floatingPersonalChatActivity;
        this.aTs = (LinearLayout) floatingPersonalChatActivity.findViewById(t.g.view_header);
        getListMain().setBackgroundColor(this.cve.getPageContext().getPageActivity().getResources().getColor(t.d.float_chat_list_background));
        this.cvf = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(t.g.floating_personal_chat_header_stub)).inflate();
        this.cvf.setOnClickListener(new ai(this));
        this.mUserDataList = this.cve.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.cvp = new aj();
        this.cvp.a(this.cvn);
        this.cvp.a(floatingPersonalChatActivity);
        this.cvp.bp(this.mUserDataList);
        this.cvg = new h((RelativeLayout) this.cvf.findViewById(t.g.im_floating_head_first), 0);
        this.cvh = new h((RelativeLayout) this.cvf.findViewById(t.g.im_floating_head_second), 1);
        this.cvi = new h((RelativeLayout) this.cvf.findViewById(t.g.im_floating_head_third), 2);
        this.cvj = new h((RelativeLayout) this.cvf.findViewById(t.g.im_floating_head_fourth), 3);
        this.cvg.setOnClickListener(this.aXp);
        this.cvh.setOnClickListener(this.aXp);
        this.cvi.setOnClickListener(this.aXp);
        this.cvj.setOnClickListener(this.aXp);
        this.cvg.a(this.cvq);
        this.cvh.a(this.cvq);
        this.cvi.a(this.cvq);
        this.cvj.a(this.cvq);
        this.cvo = new l(((ViewStub) floatingPersonalChatActivity.findViewById(t.g.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null) {
            int size = this.mUserDataList.size();
            if (this.currentIndex >= 0 && this.currentIndex < size) {
                userData = this.mUserDataList.get(this.currentIndex);
                if (userData != null) {
                    this.cvo.kb(userData.getUserName());
                    this.cvo.ko(this.cvp.c(userData));
                }
                akl();
                if (this.cvf != null) {
                    this.cvf.post(this.cuz);
                }
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aTs.addView(createStateBarFillView(), 0);
                }
                if (userData == null) {
                    boolean kc = this.cvp.kc(userData.getUserId());
                    if (!aki() && !kc && this.mTool != null) {
                        b(this.mTool.eA(6));
                        b(this.mTool.eA(2));
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
        akl();
        if (this.cvf != null) {
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
        }
        if (userData == null) {
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.cve.getPageContext().getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public void akh() {
        this.cvk = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.cvj.a((com.baidu.adp.lib.h.d) null);
            this.cvi.a((com.baidu.adp.lib.h.d) null);
            this.cvh.a((com.baidu.adp.lib.h.d) null);
            this.cvg.a((com.baidu.adp.lib.h.d) null);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.csv);
        }
    }

    private boolean aki() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean kc(String str) {
        return this.cvp.kc(str);
    }

    public void akj() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.cvl) {
                    this.cvl = true;
                    Dv();
                }
            } else if (!this.cvm) {
                this.cvg.b(this.cuN);
                this.cvh.b((com.baidu.adp.lib.h.d) null);
                this.cvi.b((com.baidu.adp.lib.h.d) null);
                this.cvj.b((com.baidu.adp.lib.h.d) null);
            }
        }
    }

    public void c(long j, int i) {
        this.cvp.ae(String.valueOf(j), i);
        this.cvo.ko(this.cvp.ke(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.cvo.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cvo.u(onClickListener);
    }

    public int kd(String str) {
        return this.cvp.ke(str);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(t.d.floating_chat_bg);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().jV(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    c(data);
                }
                boolean akm = akm();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                akk();
                if (this.cvk) {
                    akl();
                    if (akm) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        eD(z);
                    }
                }
            }
        }
    }

    private void akk() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().ka(remove.getUserId());
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

    private void eD(boolean z) {
        if (!z) {
            this.cvg.akb();
        }
        this.cvh.akb();
        this.cvi.akb();
        this.cvj.akb();
    }

    public void kr(int i) {
        if (i > 0) {
            this.cvg.akc();
        }
        if (i > 1) {
            this.cvh.akc();
        }
        if (i > 2) {
            this.cvi.akc();
        }
    }

    public void akl() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().ac(userData.getPortrait(), userData.getConcern_num());
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
                this.cvg.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.cvh.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.cvi.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.cvj.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean akm() {
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
                            this.cvp.ae(userData3.getUserId(), 1);
                        } else {
                            this.cvp.ae(userData3.getUserId(), 0);
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
            PersonalSettingItemData bb = com.baidu.tieba.im.settingcache.j.ain().bb(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (bb != null) {
                buildNormalItem.setGroupSetting(bb);
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
