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
    private TextView gWS;
    private TextView inu;
    private ImageView inv;
    private Button inz;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.gWS = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.inu = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.inv = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.inz = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.f0int == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int f = s.f(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.gHy != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.gHy.b(f, hashMap);
                        }
                    }
                }
            });
            this.inz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        al.d(this.gWS, d.C0236d.cp_cont_j, 1);
        al.d(this.inu, d.C0236d.cp_cont_f, 1);
        al.d(this.inz, d.C0236d.cp_link_tip_a, 3);
        al.c(this.inv, d.f.ad_divider);
        al.k(this.inz, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.TU);
            if (StringUtils.isNull(aVar.iiv)) {
                this.gWS.setVisibility(8);
            } else {
                this.gWS.setVisibility(0);
                this.gWS.setText(aVar.iiv);
            }
            this.inu.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.f0int == 2) {
                    this.inz.setText(getResources().getString(d.j.check_immediately));
                } else if (this.f0int == 1) {
                    this.inz.setText(getResources().getString(d.j.download));
                } else {
                    this.inz.setText(getResources().getString(d.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.f0int);
                }
            } else {
                this.inz.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int f = s.f(this.mPageContext, bVar.scheme);
            if (f == 1 || f == 2) {
                if (this.gHy != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.gHy.b(f, hashMap);
                }
            } else if (this.gHy != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.gHy.b(bVar.adq, bVar.adr, hashMap2);
            }
        }
    }
}
