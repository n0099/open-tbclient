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
    private int cyS;
    private TitleView ilc;
    private CommitView ild;
    private LinearLayout ile;
    private LinearLayout ilf;
    private ImageView ilg;
    private TextView ilh;
    private TextView ili;
    private FormCard ilj;
    private List<a> ilk;
    private String ill;
    private float ilm;
    private int iln;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bXh();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ill = "";
        this.mScreenWidth = 0;
        this.cyS = 0;
        this.ilm = 1.0f;
        this.iln = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.h.card_form, (ViewGroup) null);
        this.ilc = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.ilg = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.ilg.setEnabled(false);
        this.ild = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.ilf = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.ile = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.ilh = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.ili = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.ild != null) {
            this.ild.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.ilk, FormCardView.this.ild.getPostUrl(), FormCardView.this.ill);
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
        if (formCard != null && formCard.mIsLegal && this.ilj != formCard) {
            bXo();
            this.ilj = formCard;
            this.ill = formCard.getItemId();
            cd(formCard.mWidth, formCard.mHeight);
            this.ilc.aL(this.ilm);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilc.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.ilm);
            }
            this.ild.aL(this.ilm);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ild.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.ilm);
            }
            this.ilc.a(formCard.titleInfo);
            this.ild.a(formCard.commitInfo);
            b.bWH().a(new com.baidu.tieba.recapp.a.a(this.ild.getPostUrl()));
            bXl();
            bXn();
            bXm();
            a(this.ilc);
            a(this.ild);
            if (formCard.isCommitSuccess()) {
                bXp();
            }
            if (!formCard.mHasShown) {
                r.bWG().bWC().ca(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cd(int i, int i2) {
        this.cyS = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cyS;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.ilm = (float) (this.mScreenWidth / 750.0d);
    }

    private void bXl() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.ilj.backgroundInfo != null) {
            this.ilg.setVisibility(0);
            if (!TextUtils.isEmpty(this.ilj.backgroundInfo.img)) {
                c.jB().a(this.ilj.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.ilj.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.ilg.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.ilg.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.ilg.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.ilg.getLayoutParams().height = FormCardView.this.cyS;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.ilj.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.uP(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.ilg);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.ilg.setImageBitmap(null);
                                FormCardView.this.ilg.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.ilg.setImageBitmap(null);
                                FormCardView.this.ilg.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.ilg.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.ilg.setVisibility(8);
    }

    private void bXm() {
        FormCard.f fVar = this.ilj.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0236d.form_font_color);
        if (fVar != null) {
            this.ilh.setText(fVar.title);
            this.ilh.setTextColor(-1);
            this.ilh.setTextSize(0, dimension);
            this.ili.setText(fVar.desc);
            this.ili.setTextColor(color);
            this.ili.setTextSize(0, dimension2);
        }
    }

    private void bXn() {
        if (this.ilj.itemList != null && this.ilj.itemList.size() > 0) {
            int size = this.ilj.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.ilj.itemList.get(i);
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

    private void bXo() {
        this.ilf.removeAllViews();
        if (this.ilk != null) {
            this.ilk.clear();
        } else {
            this.ilk = new ArrayList();
        }
        this.ild.setVisibility(0);
        this.ilf.setVisibility(0);
        this.ile.setVisibility(8);
        this.ild.setClickable(true);
        this.ilg.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aL(this.ilm);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.ilf.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bXq());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.ilm);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bXq()));
        }
    }

    public void a(a aVar) {
        if (this.ilk == null) {
            this.ilk = new ArrayList();
        }
        this.ilk.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dK;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bXh()) {
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
                    if (formView2 != null && (dK = dK(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(dK);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                d(str, hashMap);
                this.ild.setClickable(false);
                return;
            }
            new e().showToast(d.f.icon_toast_game_error, d.j.form_commit_error_string);
            this.ild.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXp() {
        this.ild.setVisibility(4);
        this.ilf.setVisibility(4);
        this.ile.setVisibility(0);
    }

    private JSONObject dK(String str, String str2) {
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
            this.ild.setClickable(true);
        } else {
            b.bWH().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.ilj.setCommitState(true);
                            FormCardView.this.bXp();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.ilj.setCommitState(false);
                        } else {
                            new e().showToast(d.f.icon_toast_game_error, d.j.form_commit_fail_string);
                            FormCardView.this.ilj.setCommitState(false);
                        }
                    }
                    FormCardView.this.ild.setClickable(true);
                }
            });
        }
    }
}
