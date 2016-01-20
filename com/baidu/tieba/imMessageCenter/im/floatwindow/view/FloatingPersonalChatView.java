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
    private View.OnClickListener aRw;
    private LinearLayout bjq;
    private View.OnClickListener cdr;
    private com.baidu.adp.lib.h.d cfH;
    private FloatingPersonalChatActivity cfY;
    private LinearLayout cfZ;
    private Runnable cfu;
    private h cga;
    private h cgb;
    private h cgc;
    private h cgd;
    private boolean cge;
    private boolean cgf;
    private boolean cgg;
    private aj.a cgh;
    private l cgi;
    private aj cgj;
    private a cgk;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* loaded from: classes.dex */
    public interface a {
        void delete(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw() {
        if (this.cfZ != null) {
            this.cfZ.removeCallbacks(this.cfu);
        }
        this.cfY.finish();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().acW();
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().dY(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().acR();
    }

    public void adC() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.cgi.jo(userData.getUserName());
            this.cgi.jk(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jm(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().jm(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.cfY.jl(i);
            adC();
            adI();
            adD();
        }
    }

    private void adD() {
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
        this.cge = false;
        this.cgf = false;
        this.cgg = false;
        this.aRw = new ac(this);
        this.cfu = new ad(this);
        this.cgh = new ae(this);
        this.cgk = new af(this);
        this.cfH = new ag(this);
        this.cdr = new ah(this);
        this.cfY = floatingPersonalChatActivity;
        this.bjq = (LinearLayout) floatingPersonalChatActivity.findViewById(n.g.view_header);
        getListMain().setBackgroundColor(this.cfY.getPageContext().getPageActivity().getResources().getColor(n.d.float_chat_list_background));
        this.cfZ = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(n.g.floating_personal_chat_header_stub)).inflate();
        this.cfZ.setOnClickListener(new ai(this));
        this.mUserDataList = this.cfY.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.cgj = new aj();
        this.cgj.a(this.cgh);
        this.cgj.a(floatingPersonalChatActivity);
        this.cgj.bd(this.mUserDataList);
        this.cga = new h((RelativeLayout) this.cfZ.findViewById(n.g.im_floating_head_first), 0);
        this.cgb = new h((RelativeLayout) this.cfZ.findViewById(n.g.im_floating_head_second), 1);
        this.cgc = new h((RelativeLayout) this.cfZ.findViewById(n.g.im_floating_head_third), 2);
        this.cgd = new h((RelativeLayout) this.cfZ.findViewById(n.g.im_floating_head_fourth), 3);
        this.cga.setOnClickListener(this.aRw);
        this.cgb.setOnClickListener(this.aRw);
        this.cgc.setOnClickListener(this.aRw);
        this.cgd.setOnClickListener(this.aRw);
        this.cga.a(this.cgk);
        this.cgb.a(this.cgk);
        this.cgc.a(this.cgk);
        this.cgd.a(this.cgk);
        this.cgi = new l(((ViewStub) floatingPersonalChatActivity.findViewById(n.g.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null) {
            int size = this.mUserDataList.size();
            if (this.currentIndex >= 0 && this.currentIndex < size) {
                userData = this.mUserDataList.get(this.currentIndex);
                if (userData != null) {
                    this.cgi.jo(userData.getUserName());
                    this.cgi.jk(this.cgj.c(userData));
                }
                adI();
                if (this.cfZ != null) {
                    this.cfZ.post(this.cfu);
                }
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bjq.addView(createStateBarFillView(), 0);
                }
                if (userData == null) {
                    boolean jp = this.cgj.jp(userData.getUserId());
                    if (!adF() && !jp && this.mTool != null) {
                        b(this.mTool.ea(6));
                        b(this.mTool.ea(2));
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
        adI();
        if (this.cfZ != null) {
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
        }
        if (userData == null) {
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.cfY.getPageContext().getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public void adE() {
        this.cge = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.cgd.a((com.baidu.adp.lib.h.d) null);
            this.cgc.a((com.baidu.adp.lib.h.d) null);
            this.cgb.a((com.baidu.adp.lib.h.d) null);
            this.cga.a((com.baidu.adp.lib.h.d) null);
        }
    }

    private void b(com.baidu.tbadk.editortools.r rVar) {
        if (rVar != null && rVar != null && (rVar instanceof View)) {
            ((View) rVar).setOnClickListener(this.cdr);
        }
    }

    private boolean adF() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public boolean jp(String str) {
        return this.cgj.jp(str);
    }

    public void adG() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.cgf) {
                    this.cgf = true;
                    Bw();
                }
            } else if (!this.cgg) {
                this.cga.b(this.cfH);
                this.cgb.b((com.baidu.adp.lib.h.d) null);
                this.cgc.b((com.baidu.adp.lib.h.d) null);
                this.cgd.b((com.baidu.adp.lib.h.d) null);
            }
        }
    }

    public void d(long j, int i) {
        this.cgj.W(String.valueOf(j), i);
        this.cgi.jk(this.cgj.jr(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.cgi.refreshPersonalHeadFooter(str, bVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cgi.p(onClickListener);
    }

    public int jq(String str) {
        return this.cgj.jr(str);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(n.d.floating_chat_bg);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void i(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().jj(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    c(data);
                }
                boolean adJ = adJ();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                adH();
                if (this.cge) {
                    adI();
                    if (adJ) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        ea(z);
                    }
                }
            }
        }
    }

    private void adH() {
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
                    com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().jn(remove.getUserId());
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
            this.cga.ady();
        }
        this.cgb.ady();
        this.cgc.ady();
        this.cgd.ady();
    }

    public void jn(int i) {
        if (i > 0) {
            this.cga.adz();
        }
        if (i > 1) {
            this.cgb.adz();
        }
        if (i > 2) {
            this.cgc.adz();
        }
    }

    public void adI() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().U(userData.getPortrait(), userData.getConcern_num());
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
                this.cga.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.cgb.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.cgc.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.cgd.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean adJ() {
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
                            this.cgj.W(userData3.getUserId(), 1);
                        } else {
                            this.cgj.W(userData3.getUserId(), 0);
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
            PersonalSettingItemData aJ = com.baidu.tieba.im.settingcache.j.abO().aJ(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
