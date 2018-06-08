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
    private TextView fbT;
    private ImageView gpA;
    private Button gpE;
    private TextView gpz;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.fbT = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gpz = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gpA = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gpE = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.gpy == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.eIN != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.eIN.b(e, hashMap);
                        }
                    }
                }
            });
            this.gpE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        al.j(this.mRootView, d.C0141d.cp_bg_line_e);
        al.c(this.mTitleTextView, d.C0141d.cp_cont_j, 1);
        al.c(this.fbT, d.C0141d.cp_cont_j, 1);
        al.c(this.gpz, d.C0141d.cp_cont_f, 1);
        al.c(this.gpE, d.C0141d.cp_link_tip_a, 3);
        al.c(this.gpA, d.f.ad_divider);
        al.i(this.gpE, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gkI);
            if (StringUtils.isNull(aVar.gkJ)) {
                this.fbT.setVisibility(8);
            } else {
                this.fbT.setVisibility(0);
                this.fbT.setText(aVar.gkJ);
            }
            this.gpz.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.k.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gpy == 2) {
                    this.gpE.setText(getResources().getString(d.k.check_immediately));
                } else if (this.gpy == 1) {
                    this.gpE.setText(getResources().getString(d.k.download));
                } else {
                    this.gpE.setText(getResources().getString(d.k.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gpy);
                }
            } else {
                this.gpE.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.eIN != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.eIN.b(e, hashMap);
                }
            } else if (this.eIN != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.eIN.b(bVar.Uc, bVar.Ud, hashMap2);
            }
        }
    }
}
