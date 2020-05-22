package com.baidu.tieba.recapp.view;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.r;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aTU;
    private TextView kPK;
    private ImageView kPL;
    private Button kPP;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aTU = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.kPK = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.kPL = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.kPP = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.kPJ == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = null;
                        if (adPost.getAdvertAppInfo() != null) {
                            str = adPost.getAdvertAppInfo().dAu;
                        }
                        int b = r.b(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.iZo != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.iZo.d(b, hashMap);
                        }
                    }
                }
            });
            this.kPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        am.setViewTextColor(this.mTitleTextView, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.aTU, R.color.cp_cont_j, 1);
        am.setViewTextColor(this.kPK, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.kPP, R.color.cp_link_tip_a, 3);
        am.setImageResource(this.kPL, R.drawable.ad_divider);
        am.setBackgroundResource(this.kPP, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.XH);
            if (StringUtils.isNull(aVar.kKW)) {
                this.aTU.setVisibility(8);
            } else {
                this.aTU.setVisibility(0);
                this.aTU.setText(aVar.kKW);
            }
            this.kPK.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.kPJ == 2) {
                    this.kPP.setText(getResources().getString(R.string.check_immediately));
                } else if (this.kPJ == 1) {
                    this.kPP.setText(getResources().getString(R.string.download));
                } else {
                    this.kPP.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.kPJ);
                }
            } else {
                this.kPP.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        String str;
        if (bVar != null) {
            AdPost adPost = (AdPost) getTag();
            if (adPost == null || adPost.getAdvertAppInfo() == null) {
                str = null;
            } else {
                str = adPost.getAdvertAppInfo().dAu;
            }
            int b = r.b(this.mPageContext, bVar.scheme, str);
            if (b == 1 || b == 2) {
                if (this.iZo != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.iZo.d(b, hashMap);
                }
            } else if (this.iZo != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.iZo.a(bVar.anr, bVar.ans, hashMap2);
            }
        }
    }
}
