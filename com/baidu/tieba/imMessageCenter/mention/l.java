package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes2.dex */
public class l extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eTb;
    private OfficialNotificationListModel eTc;
    private CustomMessageListener exe = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(l.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d exf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.l.3
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (l.this.eTc != null && l.this.eTb != null && !am.isEmpty(l.this.mUid) && l.this.eTc.getUser() != null && am.equals(l.this.mUid, l.this.eTc.getUser().getUserId())) {
                switch (l.this.eTc.getLoadDataMode()) {
                    case 1:
                        l.this.eTb.refreshGo2New(l.this.eTc.getData());
                        return;
                    case 2:
                        l.this.eTb.refreshPrepage(l.this.eTc.getData());
                        return;
                    case 3:
                        l.this.eTb.refreshCheckNew(l.this.eTc.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUid;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        q(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eTb = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eTc != null) {
            this.eTb.a(this.eTc.getData());
            this.eTc.loadFirst(null);
        }
        return this.eTb.getView();
    }

    protected boolean q(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hl();
        this.eTc = new OfficialNotificationListModel(this.mPageContext);
        this.eTc.setLoadDataCallBack(this.exf);
        if (bundle != null) {
            r(bundle);
            return true;
        }
        aFo();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bu(boolean z) {
    }

    protected void r(Bundle bundle) {
        if (this.eTc != null) {
            this.eTc.setIsAcceptNotify(true);
            s(bundle);
        }
    }

    protected void aFo() {
        if (this.eTc != null) {
            this.eTc.setIsAcceptNotify(true);
            aNG();
        }
    }

    protected void s(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eTc.setUser(userData);
        }
    }

    protected void aNG() {
        if (!am.isEmpty(this.mUid) && this.mPageContext != null && this.eTc != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(d.j.system_message), null, 0);
            c(userData);
            this.eTc.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: UP */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aLW().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.exe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.exe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eTc.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == d.g.iv_head || id == d.g.tv_user_name) && !am.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void aiy() {
        if (this.eTc != null) {
            this.eTc.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eTc == null || this.eTc.getData() == null) {
            return true;
        }
        return this.eTc.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eTb != null) {
            this.eTb.onChangeSkinType();
        }
    }
}
