package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.a.b;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private int bby;
    private TitleView grb;
    private CommitView grc;
    private LinearLayout grd;
    private LinearLayout gre;
    private ImageView grf;
    private TextView grg;
    private TextView grh;
    private FormCard gri;
    private List<a> grj;
    private String grk;
    private float grl;
    private int grm;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bpk();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.grk = "";
        this.mScreenWidth = 0;
        this.bby = 0;
        this.grl = 1.0f;
        this.grm = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aQw() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.i.card_form, (ViewGroup) null);
        this.grb = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.grf = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.grf.setEnabled(false);
        this.grc = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.gre = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.grd = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.grg = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.grh = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.grc != null) {
            this.grc.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.b(FormCardView.this.grj, FormCardView.this.grc.getPostUrl(), FormCardView.this.grk);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FormCard formCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.gri != formCard) {
            bpr();
            this.gri = formCard;
            this.grk = formCard.getItemId();
            bA(formCard.mWidth, formCard.mHeight);
            this.grb.aB(this.grl);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.grb.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.grl);
            }
            this.grc.aB(this.grl);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.grc.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.grl);
            }
            this.grb.a(formCard.titleInfo);
            this.grc.a(formCard.commitInfo);
            b.boK().a(new com.baidu.tieba.recapp.a.a(this.grc.getPostUrl()));
            bpo();
            bpq();
            bpp();
            a(this.grb);
            a(this.grc);
            if (formCard.isCommitSuccess()) {
                bps();
            }
            if (!formCard.mHasShown) {
                r.boJ().boF().aD(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bA(int i, int i2) {
        this.bby = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bby;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.grl = (float) (this.mScreenWidth / 750.0d);
    }

    private void bpo() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gri.backgroundInfo != null) {
            this.grf.setVisibility(0);
            if (!TextUtils.isEmpty(this.gri.backgroundInfo.img)) {
                c.ig().a(this.gri.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.mZ() != null) {
                                    int height = aVar.mZ().getHeight();
                                    int width = aVar.mZ().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gri.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.grf.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.grf.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.grf.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.grf.getLayoutParams().height = FormCardView.this.bby;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gri.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.oN(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.grf);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.grf.setImageBitmap(null);
                                FormCardView.this.grf.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.grf.setImageBitmap(null);
                                FormCardView.this.grf.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.grf.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.grf.setVisibility(8);
    }

    private void bpp() {
        FormCard.f fVar = this.gri.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0142d.form_font_color);
        if (fVar != null) {
            this.grg.setText(fVar.title);
            this.grg.setTextColor(-1);
            this.grg.setTextSize(0, dimension);
            this.grh.setText(fVar.desc);
            this.grh.setTextColor(color);
            this.grh.setTextSize(0, dimension2);
        }
    }

    private void bpq() {
        if (this.gri.itemList != null && this.gri.itemList.size() > 0) {
            int size = this.gri.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gri.itemList.get(i);
                if (bVar != null) {
                    switch (bVar.type) {
                        case 1:
                            a(bVar, new TitleView(this.mActivity), i, size);
                            continue;
                        case 2:
                            a(bVar, new CommitView(this.mActivity), i, size);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            a(bVar, new EditView(this.mActivity), i, size);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            a(bVar, new PickerView(this.mActivity), i, size);
                            continue;
                    }
                }
            }
        }
    }

    private void bpr() {
        this.gre.removeAllViews();
        if (this.grj != null) {
            this.grj.clear();
        } else {
            this.grj = new ArrayList();
        }
        this.grc.setVisibility(0);
        this.gre.setVisibility(0);
        this.grd.setVisibility(8);
        this.grc.setClickable(true);
        this.grf.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aB(this.grl);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gre.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bpt());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.grl);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bpt()));
        }
    }

    public void a(a aVar) {
        if (this.grj == null) {
            this.grj = new ArrayList();
        }
        this.grj.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject cc;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bpk()) {
                        View frameView = formView.getFrameView();
                        if (frameView != null) {
                            formView.a(frameView, FormItemBaseView.DrawableType.ERROR_FRAME);
                        }
                        z = false;
                        z2 = z;
                    } else {
                        View frameView2 = formView.getFrameView();
                        if (frameView2 != null) {
                            formView.a(frameView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (z2) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar2 : list) {
                    FormItemBaseView formView2 = aVar2.getFormView();
                    if (formView2 != null && (cc = cc(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(cc);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.grc.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.d().showToast(d.f.icon_toast_game_error, d.k.form_commit_error_string);
            this.grc.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bps() {
        this.grc.setVisibility(4);
        this.gre.setVisibility(4);
        this.grd.setVisibility(0);
    }

    private JSONObject cc(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", str);
            jSONObject.put("value", str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private void c(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.grc.setClickable(true);
        } else {
            b.boK().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.aam) {
                            FormCardView.this.gri.setCommitState(true);
                            FormCardView.this.bps();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.d().j(hVar.errorString);
                            FormCardView.this.gri.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.d().showToast(d.f.icon_toast_game_error, d.k.form_commit_fail_string);
                            FormCardView.this.gri.setCommitState(false);
                        }
                    }
                    FormCardView.this.grc.setClickable(true);
                }
            });
        }
    }
}
