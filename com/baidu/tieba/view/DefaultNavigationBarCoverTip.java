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
    private String dBY;
    private final com.baidu.tbadk.h.e eqo;
    private View hrw;
    private View.OnClickListener lMG;
    private NavigationBarCoverTip.a lMH;
    private Activity mActivity;

    public static DefaultNavigationBarCoverTip c(Activity activity, String str, String str2) {
        if (activity == null) {
            activity = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        return new DefaultNavigationBarCoverTip(activity).fC(str, str2);
    }

    private DefaultNavigationBarCoverTip(Activity activity) {
        super(activity);
        this.lMG = new View.OnClickListener() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext<?> tbPageContext;
                DefaultNavigationBarCoverTip.this.hideTip();
                if (DefaultNavigationBarCoverTip.this.mActivity != null && !TextUtils.isEmpty(DefaultNavigationBarCoverTip.this.dBY) && (tbPageContext = UtilHelper.getTbPageContext(DefaultNavigationBarCoverTip.this.mActivity)) != null) {
                    ba.aUZ().b(tbPageContext, new String[]{DefaultNavigationBarCoverTip.this.dBY});
                }
            }
        };
        this.eqo = new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.2
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity2) {
                if (activity2 == DefaultNavigationBarCoverTip.this.mActivity) {
                    DefaultNavigationBarCoverTip.this.setCoverTipListener(null);
                    DefaultNavigationBarCoverTip.this.detach();
                }
            }
        };
        this.lMH = new NavigationBarCoverTip.a() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.3
            @Override // com.baidu.tieba.view.NavigationBarCoverTip.a
            public void Dz() {
            }

            @Override // com.baidu.tieba.view.NavigationBarCoverTip.a
            public void dlR() {
                DefaultNavigationBarCoverTip.this.detach();
            }
        };
        this.mActivity = activity;
        boM();
        setCoverTipListener(this.lMH);
    }

    public void show() {
        ViewGroup viewGroup;
        if (this.mActivity != null && this.hrw != null && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
            f(this.mActivity, this.hrw);
        }
    }

    private DefaultNavigationBarCoverTip fC(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            this.dBY = str2;
            this.hrw = View.inflate(context, R.layout.write_thread_share_guide, null);
            TextView textView = (TextView) this.hrw.findViewById(R.id.write_thread_success_tips);
            TextView textView2 = (TextView) this.hrw.findViewById(R.id.share_icon);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            textView2.setOnClickListener(this.lMG);
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

    private void boM() {
        try {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.eqo);
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
