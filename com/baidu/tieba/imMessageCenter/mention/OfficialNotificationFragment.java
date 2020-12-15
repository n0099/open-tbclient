package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes22.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b kJp;
    private OfficialNotificationListModel kJq;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.kJr, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d klg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.kJq != null && OfficialNotificationFragment.this.kJp != null && !au.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.kJq.getUser() != null && au.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.kJq.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.kJq.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.kJp.refreshGo2New(OfficialNotificationFragment.this.kJq.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.kJp.refreshPrepage(OfficialNotificationFragment.this.kJq.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.kJp.refreshCheckNew(OfficialNotificationFragment.this.kJq.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.h kJr = new com.baidu.tbadk.widget.richText.h() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.h
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public int bJm() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<ImageView> bJn() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<TextView> bJo() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<GifView> bJp() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<View> bJq() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<RelativeLayout> bJs() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void ax(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void g(Context context, String str, boolean z) {
            bf.bua().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void ay(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void az(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aA(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void u(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aB(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        au(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.kJp = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.kJq != null) {
            this.kJp.a(this.kJq.getData());
            this.kJq.loadFirst(null);
        }
        return this.kJp.getView();
    }

    protected boolean au(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.byI().bzg();
        this.kJq = new OfficialNotificationListModel(this.mPageContext);
        this.kJq.setLoadDataCallBack(this.klg);
        if (bundle != null) {
            av(bundle);
            return true;
        }
        cTf();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void av(Bundle bundle) {
        if (this.kJq != null) {
            this.kJq.setIsAcceptNotify(true);
            aw(bundle);
        }
    }

    protected void cTf() {
        if (this.kJq != null) {
            this.kJq.setIsAcceptNotify(true);
            dbJ();
        }
    }

    protected void aw(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.kJq.setUser(userData);
        }
    }

    protected void dbJ() {
        if (!au.isEmpty(this.mUid) && this.mPageContext != null && this.kJq != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.kJq.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bMU */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cZZ().b(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.jhd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jhd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.kJq.onDestroy();
        this.kJq.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !au.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void bWq() {
        if (this.kJq != null) {
            this.kJq.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.kJq == null || this.kJq.getData() == null) {
            return true;
        }
        return this.kJq.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kJp != null) {
            this.kJp.onChangeSkinType();
        }
    }
}
