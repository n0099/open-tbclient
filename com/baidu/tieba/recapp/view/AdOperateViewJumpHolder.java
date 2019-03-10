package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView gWT;
    private Button inA;
    private TextView inv;
    private ImageView inw;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.gWT = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.inv = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.inw = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.inA = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.inu == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int f = s.f(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.gHz != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.gHz.b(f, hashMap);
                        }
                    }
                }
            });
            this.inA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
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
        al.l(this.mRootView, d.C0236d.cp_bg_line_e);
        al.d(this.mTitleTextView, d.C0236d.cp_cont_j, 1);
        al.d(this.gWT, d.C0236d.cp_cont_j, 1);
        al.d(this.inv, d.C0236d.cp_cont_f, 1);
        al.d(this.inA, d.C0236d.cp_link_tip_a, 3);
        al.c(this.inw, d.f.ad_divider);
        al.k(this.inA, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.TU);
            if (StringUtils.isNull(aVar.iiw)) {
                this.gWT.setVisibility(8);
            } else {
                this.gWT.setVisibility(0);
                this.gWT.setText(aVar.iiw);
            }
            this.inv.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.inu == 2) {
                    this.inA.setText(getResources().getString(d.j.check_immediately));
                } else if (this.inu == 1) {
                    this.inA.setText(getResources().getString(d.j.download));
                } else {
                    this.inA.setText(getResources().getString(d.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.inu);
                }
            } else {
                this.inA.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int f = s.f(this.mPageContext, bVar.scheme);
            if (f == 1 || f == 2) {
                if (this.gHz != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.gHz.b(f, hashMap);
                }
            } else if (this.gHz != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.gHz.b(bVar.adq, bVar.adr, hashMap2);
            }
        }
    }
}
