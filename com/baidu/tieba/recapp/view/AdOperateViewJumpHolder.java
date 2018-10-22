package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView fuO;
    private TextView gJA;
    private ImageView gJB;
    private Button gJF;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(e.g.ad_operate_title);
        this.fuO = (TextView) this.mRootView.findViewById(e.g.ad_operate_content);
        this.gJA = (TextView) this.mRootView.findViewById(e.g.ad_operate_tag_name);
        this.gJB = (ImageView) this.mRootView.findViewById(e.g.ad_operate_divider);
        this.gJF = (Button) this.mRootView.findViewById(e.g.ad_operate_action);
        if (this.gJz == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.ffx != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.ffx.b(e, hashMap);
                        }
                    }
                }
            });
            this.gJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        al.j(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.mTitleTextView, e.d.cp_cont_j, 1);
        al.c(this.fuO, e.d.cp_cont_j, 1);
        al.c(this.gJA, e.d.cp_cont_f, 1);
        al.c(this.gJF, e.d.cp_link_tip_a, 3);
        al.c(this.gJB, e.f.ad_divider);
        al.i(this.gJF, e.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gEE);
            if (StringUtils.isNull(aVar.gEF)) {
                this.fuO.setVisibility(8);
            } else {
                this.fuO.setVisibility(0);
                this.fuO.setText(aVar.gEF);
            }
            this.gJA.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(e.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gJz == 2) {
                    this.gJF.setText(getResources().getString(e.j.check_immediately));
                } else if (this.gJz == 1) {
                    this.gJF.setText(getResources().getString(e.j.download));
                } else {
                    this.gJF.setText(getResources().getString(e.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gJz);
                }
            } else {
                this.gJF.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.ffx != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.ffx.b(e, hashMap);
                }
            } else if (this.ffx != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.ffx.b(bVar.abh, bVar.abi, hashMap2);
            }
        }
    }
}
