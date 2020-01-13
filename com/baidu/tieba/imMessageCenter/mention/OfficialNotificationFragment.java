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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes7.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b hNh;
    private OfficialNotificationListModel hNi;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener hrx = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.hNj, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d hry = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.hNi != null && OfficialNotificationFragment.this.hNh != null && !aq.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.hNi.getUser() != null && aq.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.hNi.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.hNi.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.hNh.refreshGo2New(OfficialNotificationFragment.this.hNi.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.hNh.refreshPrepage(OfficialNotificationFragment.this.hNi.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.hNh.refreshCheckNew(OfficialNotificationFragment.this.hNi.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.h hNj = new com.baidu.tbadk.widget.richText.h() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.h
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public int aSg() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<ImageView> aSh() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<TextView> aSi() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<GifView> aSj() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<View> aSk() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<LinearLayout> aSl() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<RelativeLayout> aSm() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aC(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void d(Context context, String str, boolean z) {
            ba.aEt().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aD(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aE(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aF(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void r(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aG(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        am(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hNh = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.hNi != null) {
            this.hNh.a(this.hNi.getData());
            this.hNi.loadFirst(null);
        }
        return this.hNh.getView();
    }

    protected boolean am(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIL();
        this.hNi = new OfficialNotificationListModel(this.mPageContext);
        this.hNi.setLoadDataCallBack(this.hry);
        if (bundle != null) {
            an(bundle);
            return true;
        }
        bQc();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void an(Bundle bundle) {
        if (this.hNi != null) {
            this.hNi.setIsAcceptNotify(true);
            ao(bundle);
        }
    }

    protected void bQc() {
        if (this.hNi != null) {
            this.hNi.setIsAcceptNotify(true);
            bYi();
        }
    }

    protected void ao(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.hNi.setUser(userData);
        }
    }

    protected void bYi() {
        if (!aq.isEmpty(this.mUid) && this.mPageContext != null && this.hNi != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.hNi.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ac.b(new ab<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aWq */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bWy().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.hrx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.hrx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hNi.onDestroy();
        this.hNi.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !aq.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void bdi() {
        if (this.hNi != null) {
            this.hNi.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.hNi == null || this.hNi.getData() == null) {
            return true;
        }
        return this.hNi.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hNh != null) {
            this.hNh.onChangeSkinType();
        }
    }
}
