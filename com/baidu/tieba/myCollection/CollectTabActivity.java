package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.b.h0.e0.c;
import d.b.i0.v1.b;
import java.util.Map;
/* loaded from: classes4.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final String SCHEME_MY_COLLECT = "tbmycollection://";
    public d.b.i0.v1.a mController;
    public CustomMessageListener mEditorEnableListener = new a(2022209);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Bundle) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                boolean z = bundle.getBoolean("is_enable_edit", true);
                int i = bundle.getInt("fragment_type", -1);
                if (i == -1 || i != CollectTabActivity.this.mController.f()) {
                    return;
                }
                CollectTabActivity.this.mController.k(z);
            }
        }
    }

    private void checkSchemeFromIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (StringUtils.isNull(dataString) || !dataString.startsWith(SCHEME_MY_COLLECT)) {
            return;
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (decode.startsWith("//")) {
            decode = decode.substring(2);
        }
        Map<String, String> paramPair = UrlManager.getParamPair(decode);
        if (paramPair != null) {
            TiebaStatic.log(new StatisticItem("c10320").param("obj_locate", paramPair.get("obj_locate")).param("obj_type", 1).param("obj_source", paramPair.get("obj_source")).param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2)).param(TiebaStatic.Params.OBJ_TO, 4).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a081";
    }

    public void initTabsOnActivityCreated() {
        d.b.h0.q.a aVar = new d.b.h0.q.a(getPageContext().getPageActivity());
        ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
        aVar.a(threadDelegateStatic);
        if (aVar.b() != null) {
            c fragmentTabStructure = threadDelegateStatic.getFragmentTabStructure();
            if (fragmentTabStructure == null) {
                return;
            }
            fragmentTabStructure.f50154a.setArguments(new Bundle());
        }
        this.mController.h(aVar.c());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment e2 = this.mController.e();
        if (e2 != null) {
            e2.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.mController.j(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mController.d()) {
            boolean z = !this.mController.i();
            if (z) {
                d.b.i0.v1.c.a("c14067");
            }
            this.mController.b(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_tab_activity);
        this.mController = new d.b.i0.v1.a(this);
        registerListener(this.mEditorEnableListener);
        initTabsOnActivityCreated();
        checkSchemeFromIntent(getIntent());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        checkSchemeFromIntent(intent);
        setIntent(intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b.b().f(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.i0.v1.c.a("c14061");
        b.b().f(true);
        b.b().e(false);
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), 28);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception unused) {
        }
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
    }
}
