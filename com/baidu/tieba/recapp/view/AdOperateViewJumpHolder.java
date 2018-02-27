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
    private TextView Xh;
    private TextView fuy;
    private TextView gHM;
    private ImageView gHN;
    private Button gHR;
    private View mRootView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.Xh = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.fuy = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gHM = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gHN = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gHR = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.gHL == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int f = s.f(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.fbq != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.fbq.b(f, hashMap);
                        }
                    }
                }
            });
            this.gHR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        aj.t(this.mRootView, d.C0141d.cp_bg_line_e);
        aj.e(this.Xh, d.C0141d.cp_cont_j, 1);
        aj.e(this.fuy, d.C0141d.cp_cont_j, 1);
        aj.e(this.gHM, d.C0141d.cp_cont_f, 1);
        aj.e(this.gHR, d.C0141d.cp_link_tip_a, 3);
        aj.c(this.gHN, d.f.ad_divider);
        aj.s(this.gHR, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.Xh.setText(aVar.gDk);
            if (StringUtils.isNull(aVar.gDl)) {
                this.fuy.setVisibility(8);
            } else {
                this.fuy.setVisibility(0);
                this.fuy.setText(aVar.gDl);
            }
            this.gHM.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gHL == 2) {
                    this.gHR.setText(getResources().getString(d.j.check_immediately));
                } else if (this.gHL == 1) {
                    this.gHR.setText(getResources().getString(d.j.download));
                } else {
                    this.gHR.setText(getResources().getString(d.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gHL);
                }
            } else {
                this.gHR.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int f = s.f(this.mPageContext, bVar.scheme);
            if (f == 1 || f == 2) {
                if (this.fbq != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.fbq.b(f, hashMap);
                }
            } else if (this.fbq != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.fbq.b(bVar.azH, bVar.azI, hashMap2);
            }
        }
    }
}
