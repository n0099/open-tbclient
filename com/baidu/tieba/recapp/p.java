package com.baidu.tieba.recapp;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.view.JumpButton;
import com.baidu.tieba.recapp.view.AdCriusCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
/* loaded from: classes26.dex */
public class p implements com.baidu.g.a.b.b {
    @Override // com.baidu.g.a.b.b
    public View C(Context context, String str) {
        if ("head".equalsIgnoreCase(str)) {
            HeadImageView headImageView = new HeadImageView(context);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setDrawerType(1);
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            headImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            headImageView.setDefaultBgResource(R.color.cp_bg_line_e);
            return headImageView;
        } else if ("time".equalsIgnoreCase(str)) {
            TextView textView = new TextView(context);
            textView.setIncludeFontPadding(false);
            return textView;
        } else if ("closead".equalsIgnoreCase(str)) {
            return new AdCriusCloseView(context);
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
                adThreadCommentAndPraiseInfoLayout.getRootView().setGravity(16);
                linearLayout.addView(adThreadCommentAndPraiseInfoLayout);
                ViewGroup.LayoutParams layoutParams = adThreadCommentAndPraiseInfoLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    adThreadCommentAndPraiseInfoLayout.setLayoutParams(layoutParams);
                }
                adThreadCommentAndPraiseInfoLayout.getRootView().setGravity(16);
                return linearLayout;
            }
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            return imageView;
        }
    }

    @Override // com.baidu.g.a.b.b
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, boolean z) {
        if (aVar == null) {
            return false;
        }
        if (view instanceof HeadImageView) {
            if (aVar.auv > 0.0f) {
                ((HeadImageView) view).setRadius((int) (aVar.auv * view.getResources().getDisplayMetrics().density));
            } else {
                ((HeadImageView) view).setRadius(0);
            }
            ((HeadImageView) view).startLoad(aVar.src, 10, false);
            return true;
        }
        if ("time".equalsIgnoreCase(str)) {
            TextView textView = (TextView) view;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textView.setTextColor(aVar.auA);
            } else {
                textView.setTextColor(aVar.color);
            }
            textView.setTextSize(0, aVar.auB * view.getContext().getResources().getDisplayMetrics().density);
            textView.setText(aVar.text);
        } else if (view instanceof JumpButton) {
            ((JumpButton) view).setText(aVar.text);
            return true;
        } else if ("download".equalsIgnoreCase(str) && (view instanceof ApkDownloadView)) {
            if (TextUtils.equals("pb-banner", aVar.auC)) {
                ((ApkDownloadView) view).setIsPbDownload(true);
                ((ApkDownloadView) view).setTextSize((int) aVar.auB);
            } else {
                ((ApkDownloadView) view).setIsPbDownload(false);
            }
            ((ApkDownloadView) view).setDefaultText(aVar.text);
        }
        return false;
    }
}
