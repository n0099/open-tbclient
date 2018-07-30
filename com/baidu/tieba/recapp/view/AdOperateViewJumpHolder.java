package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView ffQ;
    private TextView guE;
    private ImageView guF;
    private Button guJ;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.ffQ = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.guE = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.guF = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.guJ = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.guD == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.eQz != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.eQz.b(e, hashMap);
                        }
                    }
                }
            });
            this.guJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        am.j(this.mRootView, d.C0140d.cp_bg_line_e);
        am.c(this.mTitleTextView, d.C0140d.cp_cont_j, 1);
        am.c(this.ffQ, d.C0140d.cp_cont_j, 1);
        am.c(this.guE, d.C0140d.cp_cont_f, 1);
        am.c(this.guJ, d.C0140d.cp_link_tip_a, 3);
        am.c(this.guF, d.f.ad_divider);
        am.i(this.guJ, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gpI);
            if (StringUtils.isNull(aVar.gpJ)) {
                this.ffQ.setVisibility(8);
            } else {
                this.ffQ.setVisibility(0);
                this.ffQ.setText(aVar.gpJ);
            }
            this.guE.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.guD == 2) {
                    this.guJ.setText(getResources().getString(d.j.check_immediately));
                } else if (this.guD == 1) {
                    this.guJ.setText(getResources().getString(d.j.download));
                } else {
                    this.guJ.setText(getResources().getString(d.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.guD);
                }
            } else {
                this.guJ.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.eQz != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.eQz.b(e, hashMap);
                }
            } else if (this.eQz != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.eQz.b(bVar.Ua, bVar.Ub, hashMap2);
            }
        }
    }
}
