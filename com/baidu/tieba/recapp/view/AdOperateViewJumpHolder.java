package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView Xn;
    private TextView fuK;
    private TextView gIb;
    private ImageView gIc;
    private Button gIg;
    private View mRootView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.Xn = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.fuK = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gIb = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gIc = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gIg = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.gIa == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int f = s.f(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.fbC != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.fbC.b(f, hashMap);
                        }
                    }
                }
            });
            this.gIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        aj.t(this.mRootView, d.C0140d.cp_bg_line_e);
        aj.e(this.Xn, d.C0140d.cp_cont_j, 1);
        aj.e(this.fuK, d.C0140d.cp_cont_j, 1);
        aj.e(this.gIb, d.C0140d.cp_cont_f, 1);
        aj.e(this.gIg, d.C0140d.cp_link_tip_a, 3);
        aj.c(this.gIc, d.f.ad_divider);
        aj.s(this.gIg, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.Xn.setText(aVar.gDz);
            if (StringUtils.isNull(aVar.gDA)) {
                this.fuK.setVisibility(8);
            } else {
                this.fuK.setVisibility(0);
                this.fuK.setText(aVar.gDA);
            }
            this.gIb.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gIa == 2) {
                    this.gIg.setText(getResources().getString(d.j.check_immediately));
                } else if (this.gIa == 1) {
                    this.gIg.setText(getResources().getString(d.j.download));
                } else {
                    this.gIg.setText(getResources().getString(d.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gIa);
                }
            } else {
                this.gIg.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int f = s.f(this.mPageContext, bVar.scheme);
            if (f == 1 || f == 2) {
                if (this.fbC != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.fbC.b(f, hashMap);
                }
            } else if (this.fbC != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.fbC.b(bVar.azQ, bVar.azR, hashMap2);
            }
        }
    }
}
