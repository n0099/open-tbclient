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
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView hwZ;
    private TextView iPG;
    private ImageView iPH;
    private Button iPL;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.hwZ = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.iPG = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.iPH = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.iPL = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.iPF == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = null;
                        if (adPost.getAdvertAppInfo() != null) {
                            str = adPost.getAdvertAppInfo().bFs;
                        }
                        int a = s.a(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.hhI != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.hhI.b(a, hashMap);
                        }
                    }
                }
            });
            this.iPL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        am.l(this.mRootView, R.color.cp_bg_line_e);
        am.f(this.mTitleTextView, R.color.cp_cont_j, 1);
        am.f(this.hwZ, R.color.cp_cont_j, 1);
        am.f(this.iPG, R.color.cp_cont_f, 1);
        am.f(this.iPL, R.color.cp_link_tip_a, 3);
        am.c(this.iPH, (int) R.drawable.ad_divider);
        am.k(this.iPL, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.RY);
            if (StringUtils.isNull(aVar.iKK)) {
                this.hwZ.setVisibility(8);
            } else {
                this.hwZ.setVisibility(0);
                this.hwZ.setText(aVar.iKK);
            }
            this.iPG.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.iPF == 2) {
                    this.iPL.setText(getResources().getString(R.string.check_immediately));
                } else if (this.iPF == 1) {
                    this.iPL.setText(getResources().getString(R.string.download));
                } else {
                    this.iPL.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.iPF);
                }
            } else {
                this.iPL.setText(aVar.buttonText);
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
                str = adPost.getAdvertAppInfo().bFs;
            }
            int a = s.a(this.mPageContext, bVar.scheme, str);
            if (a == 1 || a == 2) {
                if (this.hhI != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.hhI.b(a, hashMap);
                }
            } else if (this.hhI != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.hhI.b(bVar.abI, bVar.abJ, hashMap2);
            }
        }
    }
}
