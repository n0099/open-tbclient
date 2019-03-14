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
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.a.b;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.r;
import com.baidu.ubc.UBC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private int cyP;
    private TitleView ikW;
    private CommitView ikX;
    private LinearLayout ikY;
    private LinearLayout ikZ;
    private ImageView ila;
    private TextView ilb;
    private TextView ilc;
    private FormCard ild;
    private List<a> ile;
    private String ilf;
    private float ilg;
    private int ilh;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bXk();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ilf = "";
        this.mScreenWidth = 0;
        this.cyP = 0;
        this.ilg = 1.0f;
        this.ilh = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.h.card_form, (ViewGroup) null);
        this.ikW = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.ila = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.ila.setEnabled(false);
        this.ikX = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.ikZ = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.ikY = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.ilb = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.ilc = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.ikX != null) {
            this.ikX.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.ile, FormCardView.this.ikX.getPostUrl(), FormCardView.this.ilf);
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
        if (formCard != null && formCard.mIsLegal && this.ild != formCard) {
            bXr();
            this.ild = formCard;
            this.ilf = formCard.getItemId();
            cd(formCard.mWidth, formCard.mHeight);
            this.ikW.aL(this.ilg);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikW.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.ilg);
            }
            this.ikX.aL(this.ilg);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ikX.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.ilg);
            }
            this.ikW.a(formCard.titleInfo);
            this.ikX.a(formCard.commitInfo);
            b.bWK().a(new com.baidu.tieba.recapp.a.a(this.ikX.getPostUrl()));
            bXo();
            bXq();
            bXp();
            a(this.ikW);
            a(this.ikX);
            if (formCard.isCommitSuccess()) {
                bXs();
            }
            if (!formCard.mHasShown) {
                r.bWJ().bWF().ca(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cd(int i, int i2) {
        this.cyP = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cyP;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.ilg = (float) (this.mScreenWidth / 750.0d);
    }

    private void bXo() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.ild.backgroundInfo != null) {
            this.ila.setVisibility(0);
            if (!TextUtils.isEmpty(this.ild.backgroundInfo.img)) {
                c.jB().a(this.ild.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.oy() != null) {
                                    int height = aVar.oy().getHeight();
                                    int width = aVar.oy().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.ild.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.ila.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.ila.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.ila.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.ila.getLayoutParams().height = FormCardView.this.cyP;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.ild.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.uP(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.ila);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.ila.setImageBitmap(null);
                                FormCardView.this.ila.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.ila.setImageBitmap(null);
                                FormCardView.this.ila.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.ila.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.ila.setVisibility(8);
    }

    private void bXp() {
        FormCard.f fVar = this.ild.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0277d.form_font_color);
        if (fVar != null) {
            this.ilb.setText(fVar.title);
            this.ilb.setTextColor(-1);
            this.ilb.setTextSize(0, dimension);
            this.ilc.setText(fVar.desc);
            this.ilc.setTextColor(color);
            this.ilc.setTextSize(0, dimension2);
        }
    }

    private void bXq() {
        if (this.ild.itemList != null && this.ild.itemList.size() > 0) {
            int size = this.ild.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.ild.itemList.get(i);
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

    private void bXr() {
        this.ikZ.removeAllViews();
        if (this.ile != null) {
            this.ile.clear();
        } else {
            this.ile = new ArrayList();
        }
        this.ikX.setVisibility(0);
        this.ikZ.setVisibility(0);
        this.ikY.setVisibility(8);
        this.ikX.setClickable(true);
        this.ila.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aL(this.ilg);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.ikZ.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bXt());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.ilg);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bXt()));
        }
    }

    public void a(a aVar) {
        if (this.ile == null) {
            this.ile = new ArrayList();
        }
        this.ile.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dJ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bXk()) {
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
                    if (formView2 != null && (dJ = dJ(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(dJ);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                d(str, hashMap);
                this.ikX.setClickable(false);
                return;
            }
            new e().showToast(d.f.icon_toast_game_error, d.j.form_commit_error_string);
            this.ikX.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        this.ikX.setVisibility(4);
        this.ikZ.setVisibility(4);
        this.ikY.setVisibility(0);
    }

    private JSONObject dJ(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", str);
            jSONObject.put(UBC.CONTENT_KEY_VALUE, str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private void d(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.ikX.setClickable(true);
        } else {
            b.bWK().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.ild.setCommitState(true);
                            FormCardView.this.bXs();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.ild.setCommitState(false);
                        } else {
                            new e().showToast(d.f.icon_toast_game_error, d.j.form_commit_fail_string);
                            FormCardView.this.ild.setCommitState(false);
                        }
                    }
                    FormCardView.this.ikX.setClickable(true);
                }
            });
        }
    }
}
