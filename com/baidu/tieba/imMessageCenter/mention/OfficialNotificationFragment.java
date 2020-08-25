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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes16.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b jFi;
    private OfficialNotificationListModel jFj;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener jgJ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.jFk, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d jgK = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.jFj != null && OfficialNotificationFragment.this.jFi != null && !at.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.jFj.getUser() != null && at.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.jFj.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.jFj.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.jFi.refreshGo2New(OfficialNotificationFragment.this.jFj.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.jFi.refreshPrepage(OfficialNotificationFragment.this.jFj.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.jFi.refreshCheckNew(OfficialNotificationFragment.this.jFj.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.i jFk = new com.baidu.tbadk.widget.richText.i() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.i
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public int byh() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<ImageView> byi() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<TextView> byj() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<GifView> byk() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<View> byl() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<LinearLayout> bym() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<RelativeLayout> byn() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void aq(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void f(Context context, String str, boolean z) {
            be.bju().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void ar(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void as(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void at(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void r(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void au(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        at(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.jFi = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.jFj != null) {
            this.jFi.a(this.jFj.getData());
            this.jFj.loadFirst(null);
        }
        return this.jFi.getView();
    }

    protected boolean at(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bot();
        this.jFj = new OfficialNotificationListModel(this.mPageContext);
        this.jFj.setLoadDataCallBack(this.jgK);
        if (bundle != null) {
            au(bundle);
            return true;
        }
        cBl();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void au(Bundle bundle) {
        if (this.jFj != null) {
            this.jFj.setIsAcceptNotify(true);
            av(bundle);
        }
    }

    protected void cBl() {
        if (this.jFj != null) {
            this.jFj.setIsAcceptNotify(true);
            cJT();
        }
    }

    protected void av(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.jFj.setUser(userData);
        }
    }

    protected void cJT() {
        if (!at.isEmpty(this.mUid) && this.mPageContext != null && this.jFj != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.jFj.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bBB */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cIj().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.jgJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jgJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jFj.onDestroy();
        this.jFj.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !at.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void bKn() {
        if (this.jFj != null) {
            this.jFj.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.jFj == null || this.jFj.getData() == null) {
            return true;
        }
        return this.jFj.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jFi != null) {
            this.jFi.onChangeSkinType();
        }
    }
}
