package com.baidu.tieba.recapp;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.view.JumpButton;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes3.dex */
public class p implements com.baidu.b.a.b.b {
    @Override // com.baidu.b.a.b.b
    public View H(Context context, String str) {
        if ("head".equalsIgnoreCase(str)) {
            HeadImageView headImageView = new HeadImageView(context);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setDrawerType(1);
            headImageView.setDefaultResource(d.f.icon_default_avatar100);
            headImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
            headImageView.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            return headImageView;
        } else if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(str)) {
            TextView textView = new TextView(context);
            textView.setIncludeFontPadding(false);
            return textView;
        } else if ("closead".equalsIgnoreCase(str)) {
            return new AdCloseView(context);
        } else {
            if ("download".equalsIgnoreCase(str)) {
                return new ApkDownloadView(context);
            }
            if ("viewbtn".equalsIgnoreCase(str)) {
                return new JumpButton(context);
            }
            if ("bottombar".equalsIgnoreCase(str)) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = new AdThreadCommentAndPraiseInfoLayout(context);
                adThreadCommentAndPraiseInfoLayout.setStyle(1);
                adThreadCommentAndPraiseInfoLayout.setGravity(16);
                linearLayout.addView(adThreadCommentAndPraiseInfoLayout);
                ViewGroup.LayoutParams layoutParams = adThreadCommentAndPraiseInfoLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    adThreadCommentAndPraiseInfoLayout.setLayoutParams(layoutParams);
                }
                adThreadCommentAndPraiseInfoLayout.setGravity(16);
                return linearLayout;
            }
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            return imageView;
        }
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view2, com.baidu.b.a.a.a aVar, boolean z) {
        if (aVar == null) {
            return false;
        }
        if (view2 instanceof HeadImageView) {
            if (aVar.Lw > 0.0f) {
                ((HeadImageView) view2).setRadius((int) (aVar.Lw * view2.getResources().getDisplayMetrics().density));
            } else {
                ((HeadImageView) view2).setRadius(0);
            }
            ((HeadImageView) view2).startLoad(aVar.src, 10, false);
            return true;
        }
        if (CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME.equalsIgnoreCase(str)) {
            TextView textView = (TextView) view2;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textView.setTextColor(aVar.Lx);
            } else {
                textView.setTextColor(aVar.color);
            }
            textView.setTextSize(0, aVar.Ly * view2.getContext().getResources().getDisplayMetrics().density);
            textView.setText(aVar.text);
        } else if (view2 instanceof JumpButton) {
            ((JumpButton) view2).setText(aVar.text);
            return true;
        } else if ("download".equalsIgnoreCase(str) && (view2 instanceof ApkDownloadView)) {
            ((ApkDownloadView) view2).setDefaultText(aVar.text);
        }
        return false;
    }
}
