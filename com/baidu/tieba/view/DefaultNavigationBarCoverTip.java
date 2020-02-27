package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class DefaultNavigationBarCoverTip extends NavigationBarCoverTip {
    private String cOz;
    private final com.baidu.tbadk.h.e dBL;
    private View gsy;
    private View.OnClickListener kHV;
    private NavigationBarCoverTip.a kHW;
    private Activity mActivity;

    public static DefaultNavigationBarCoverTip d(Activity activity, String str, String str2) {
        if (activity == null) {
            activity = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        return new DefaultNavigationBarCoverTip(activity).eO(str, str2);
    }

    private DefaultNavigationBarCoverTip(Activity activity) {
        super(activity);
        this.kHV = new View.OnClickListener() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext<?> tbPageContext;
                DefaultNavigationBarCoverTip.this.hideTip();
                if (DefaultNavigationBarCoverTip.this.mActivity != null && !TextUtils.isEmpty(DefaultNavigationBarCoverTip.this.cOz) && (tbPageContext = UtilHelper.getTbPageContext(DefaultNavigationBarCoverTip.this.mActivity)) != null) {
                    ba.aGE().b(tbPageContext, new String[]{DefaultNavigationBarCoverTip.this.cOz});
                }
            }
        };
        this.dBL = new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.2
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity2) {
                if (activity2 == DefaultNavigationBarCoverTip.this.mActivity) {
                    DefaultNavigationBarCoverTip.this.setCoverTipListener(null);
                    DefaultNavigationBarCoverTip.this.detach();
                }
            }
        };
        this.kHW = new NavigationBarCoverTip.a() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.3
            @Override // com.baidu.tieba.view.NavigationBarCoverTip.a
            public void xm() {
            }

            @Override // com.baidu.tieba.view.NavigationBarCoverTip.a
            public void cTt() {
                DefaultNavigationBarCoverTip.this.detach();
            }
        };
        this.mActivity = activity;
        bbn();
        setCoverTipListener(this.kHW);
    }

    public void show() {
        ViewGroup viewGroup;
        if (this.mActivity != null && this.gsy != null && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
            g(this.mActivity, this.gsy);
        }
    }

    private DefaultNavigationBarCoverTip eO(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            this.cOz = str2;
            this.gsy = View.inflate(context, R.layout.write_thread_share_guide, null);
            TextView textView = (TextView) this.gsy.findViewById(R.id.write_thread_success_tips);
            TextView textView2 = (TextView) this.gsy.findViewById(R.id.share_icon);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            textView2.setOnClickListener(this.kHV);
            if (TextUtils.isEmpty(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(context.getString(R.string.jump_link));
            }
            am.setViewTextColor(textView, (int) R.color.cp_cont_a);
            am.setViewTextColor(textView2, (int) R.color.cp_cont_a);
            am.setBackgroundResource(textView2, R.drawable.share_now_bg);
            am.setBackgroundColor(this, R.color.cp_link_tip_a_alpha95);
        }
        return this;
    }

    private void bbn() {
        try {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.dBL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detach() {
        onDestroy();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }
}
