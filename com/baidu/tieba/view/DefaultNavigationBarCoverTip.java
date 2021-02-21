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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class DefaultNavigationBarCoverTip extends NavigationBarCoverTip {
    private String eNn;
    private final com.baidu.tbadk.h.g fHE;
    private View jlC;
    private Activity mActivity;
    private View.OnClickListener nXr;
    private NavigationBarCoverTip.a nXs;

    public static DefaultNavigationBarCoverTip d(Activity activity, String str, String str2) {
        if (activity == null) {
            activity = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        return new DefaultNavigationBarCoverTip(activity).gN(str, str2);
    }

    private DefaultNavigationBarCoverTip(Activity activity) {
        super(activity);
        this.nXr = new View.OnClickListener() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext<?> tbPageContext;
                DefaultNavigationBarCoverTip.this.hideTip();
                if (DefaultNavigationBarCoverTip.this.mActivity != null && !TextUtils.isEmpty(DefaultNavigationBarCoverTip.this.eNn) && (tbPageContext = UtilHelper.getTbPageContext(DefaultNavigationBarCoverTip.this.mActivity)) != null) {
                    bf.bsV().b(tbPageContext, new String[]{DefaultNavigationBarCoverTip.this.eNn});
                }
            }
        };
        this.fHE = new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.2
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity2) {
                if (activity2 == DefaultNavigationBarCoverTip.this.mActivity) {
                    DefaultNavigationBarCoverTip.this.setCoverTipListener(null);
                    DefaultNavigationBarCoverTip.this.detach();
                }
            }
        };
        this.nXs = new NavigationBarCoverTip.a() { // from class: com.baidu.tieba.view.DefaultNavigationBarCoverTip.3
            @Override // com.baidu.tieba.view.NavigationBarCoverTip.a
            public void onShow() {
            }

            @Override // com.baidu.tieba.view.NavigationBarCoverTip.a
            public void dVZ() {
                DefaultNavigationBarCoverTip.this.detach();
            }
        };
        this.mActivity = activity;
        bNT();
        setCoverTipListener(this.nXs);
    }

    public void show() {
        ViewGroup viewGroup;
        if (this.mActivity != null && this.jlC != null && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
            e(this.mActivity, this.jlC);
        }
    }

    private DefaultNavigationBarCoverTip gN(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            this.eNn = str2;
            this.jlC = View.inflate(context, R.layout.write_thread_share_guide, null);
            TextView textView = (TextView) this.jlC.findViewById(R.id.write_thread_success_tips);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.jlC.findViewById(R.id.share_icon);
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.buY();
            tBSpecificationBtn.setConfig(cVar);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            tBSpecificationBtn.setOnClickListener(this.nXr);
            if (TextUtils.isEmpty(str2)) {
                tBSpecificationBtn.setVisibility(8);
            } else {
                tBSpecificationBtn.setVisibility(0);
                tBSpecificationBtn.setText(context.getString(R.string.jump_link));
            }
            ap.setViewTextColor(textView, R.color.CAM_X0101);
            tBSpecificationBtn.bup();
            ap.setBackgroundColor(this, R.color.CAM_X0302);
        }
        return this;
    }

    private void bNT() {
        try {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.fHE);
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
