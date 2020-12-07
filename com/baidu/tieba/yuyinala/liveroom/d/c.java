package com.baidu.tieba.yuyinala.liveroom.d;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class c {
    private TbImageView hiq;
    private View hir;
    private TbPageContext mContext;
    private TextView mTitleView;
    private String mUrl;
    private View mView;

    public c(@NonNull TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.back_to_come_button, (ViewGroup) null);
        this.hir = this.mView.findViewById(a.f.back_to_come_root);
        this.hiq = (TbImageView) this.mView.findViewById(a.f.back_to_come_logo);
        this.mTitleView = (TextView) this.mView.findViewById(a.f.back_to_come_title);
    }

    private boolean isVisible() {
        return this.mView != null && this.mView.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void show() {
        if (this.mView != null && this.mView.getParent() != null && !isVisible()) {
            this.mView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.mView != null && this.mView.getParent() != null && isVisible()) {
            this.mView.setVisibility(8);
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getImageUrl())) {
                this.hiq.setVisibility(0);
                this.hiq.setAutoChangeStyle(false);
                this.hiq.startLoad(bVar.getImageUrl(), 10, false);
            } else if (bVar.getImageId() != 0) {
                this.hiq.setVisibility(0);
                this.hiq.setImageResource(bVar.getImageId());
            } else {
                this.hiq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bVar.getTitle())) {
                this.mTitleView.setText(bVar.getTitle());
            } else if (bVar.ccw() != 0) {
                this.mTitleView.setText(bVar.ccw());
            }
            if (!TextUtils.isEmpty(bVar.getScheme())) {
                this.mUrl = bVar.getScheme();
            }
        }
    }

    public void ccx() {
        try {
            if (!TextUtils.isEmpty(this.mUrl) && this.mContext != null) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.mUrl));
                intent.setFlags(268435456);
                this.mContext.getPageActivity().startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_back_to_come_error);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View ccy() {
        return this.hir;
    }
}
