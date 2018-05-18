package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView eQB;
    private TextView gef;
    private ImageView geg;
    private Button gek;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view2) {
        super(tbPageContext, i, view2);
        this.mRootView = view2;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.eQB = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gef = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.geg = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gek = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.gee == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.exr != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.exr.b(e, hashMap);
                        }
                    }
                }
            });
            this.gek.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        AdOperateViewJumpHolder.this.a(adPost.adData.buttonClick);
                    }
                }
            });
        }
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ak.j(this.mRootView, d.C0126d.cp_bg_line_e);
        ak.c(this.mTitleTextView, d.C0126d.cp_cont_j, 1);
        ak.c(this.eQB, d.C0126d.cp_cont_j, 1);
        ak.c(this.gef, d.C0126d.cp_cont_f, 1);
        ak.c(this.gek, d.C0126d.cp_link_tip_a, 3);
        ak.c(this.geg, d.f.ad_divider);
        ak.i(this.gek, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.fZq);
            if (StringUtils.isNull(aVar.fZr)) {
                this.eQB.setVisibility(8);
            } else {
                this.eQB.setVisibility(0);
                this.eQB.setText(aVar.fZr);
            }
            this.gef.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.k.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gee == 2) {
                    this.gek.setText(getResources().getString(d.k.check_immediately));
                } else if (this.gee == 1) {
                    this.gek.setText(getResources().getString(d.k.download));
                } else {
                    this.gek.setText(getResources().getString(d.k.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gee);
                }
            } else {
                this.gek.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.exr != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.exr.b(e, hashMap);
                }
            } else if (this.exr != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.exr.b(bVar.LS, bVar.LT, hashMap2);
            }
        }
    }
}
