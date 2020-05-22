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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes9.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b iPx;
    private OfficialNotificationListModel iPy;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener itM = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.iPz, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d itN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.iPy != null && OfficialNotificationFragment.this.iPx != null && !aq.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.iPy.getUser() != null && aq.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.iPy.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.iPy.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.iPx.refreshGo2New(OfficialNotificationFragment.this.iPy.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.iPx.refreshPrepage(OfficialNotificationFragment.this.iPy.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.iPx.refreshCheckNew(OfficialNotificationFragment.this.iPy.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.h iPz = new com.baidu.tbadk.widget.richText.h() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.h
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public int biX() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<ImageView> biY() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<TextView> biZ() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<GifView> bja() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<View> bjb() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<LinearLayout> bjc() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<RelativeLayout> bjd() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void al(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void f(Context context, String str, boolean z) {
            ba.aUZ().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void am(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void an(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void ao(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void s(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void ap(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        as(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.iPx = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.iPy != null) {
            this.iPx.a(this.iPy.getData());
            this.iPy.loadFirst(null);
        }
        return this.iPx.getView();
    }

    protected boolean as(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZN();
        this.iPy = new OfficialNotificationListModel(this.mPageContext);
        this.iPy.setLoadDataCallBack(this.itN);
        if (bundle != null) {
            at(bundle);
            return true;
        }
        ciU();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void at(Bundle bundle) {
        if (this.iPy != null) {
            this.iPy.setIsAcceptNotify(true);
            au(bundle);
        }
    }

    protected void ciU() {
        if (this.iPy != null) {
            this.iPy.setIsAcceptNotify(true);
            crc();
        }
    }

    protected void au(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.iPy.setUser(userData);
        }
    }

    protected void crc() {
        if (!aq.isEmpty(this.mUid) && this.mPageContext != null && this.iPy != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.iPy.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bmZ */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cpr().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.itM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.itM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.iPy.onDestroy();
        this.iPy.setLoadDataCallBack(null);
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

    public void buF() {
        if (this.iPy != null) {
            this.iPy.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.iPy == null || this.iPy.getData() == null) {
            return true;
        }
        return this.iPy.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPx != null) {
            this.iPx.onChangeSkinType();
        }
    }
}
