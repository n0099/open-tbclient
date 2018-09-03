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
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.f;
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
    private int bbG;
    private float gsA;
    private int gsB;
    private TitleView gsq;
    private CommitView gsr;
    private LinearLayout gss;
    private LinearLayout gst;
    private ImageView gsu;
    private TextView gsv;
    private TextView gsw;
    private FormCard gsx;
    private List<a> gsy;
    private String gsz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bnP();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gsz = "";
        this.mScreenWidth = 0;
        this.bbG = 0;
        this.gsA = 1.0f;
        this.gsB = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRu() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(f.h.card_form, (ViewGroup) null);
        this.gsq = (TitleView) this.mRootView.findViewById(f.g.form_title_view);
        this.gsu = (ImageView) this.mRootView.findViewById(f.g.tb_img_background);
        this.gsu.setEnabled(false);
        this.gsr = (CommitView) this.mRootView.findViewById(f.g.form_commit_view);
        this.gst = (LinearLayout) this.mRootView.findViewById(f.g.item_content_view);
        this.gss = (LinearLayout) this.mRootView.findViewById(f.g.form_commit_success_view);
        this.gsv = (TextView) this.mRootView.findViewById(f.g.form_success_title);
        this.gsw = (TextView) this.mRootView.findViewById(f.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gsr != null) {
            this.gsr.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.b(FormCardView.this.gsy, FormCardView.this.gsr.getPostUrl(), FormCardView.this.gsz);
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
        if (formCard != null && formCard.mIsLegal && this.gsx != formCard) {
            bnW();
            this.gsx = formCard;
            this.gsz = formCard.getItemId();
            bB(formCard.mWidth, formCard.mHeight);
            this.gsq.aB(this.gsA);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsq.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(f.e.form_size90)) * this.gsA);
            }
            this.gsr.aB(this.gsA);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gsr.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(f.e.form_size90)) * this.gsA);
            }
            this.gsq.a(formCard.titleInfo);
            this.gsr.a(formCard.commitInfo);
            b.bnp().a(new com.baidu.tieba.recapp.a.a(this.gsr.getPostUrl()));
            bnT();
            bnV();
            bnU();
            a(this.gsq);
            a(this.gsr);
            if (formCard.isCommitSuccess()) {
                bnX();
            }
            if (!formCard.mHasShown) {
                r.bno().bnk().az(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bB(int i, int i2) {
        this.bbG = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bbG;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gsA = (float) (this.mScreenWidth / 750.0d);
    }

    private void bnT() {
        this.mRootView.setBackgroundResource(f.C0146f.form_defalut_bg_image);
        if (this.gsx.backgroundInfo != null) {
            this.gsu.setVisibility(0);
            if (!TextUtils.isEmpty(this.gsx.backgroundInfo.img)) {
                c.ih().a(this.gsx.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.nb() != null) {
                                    int height = aVar.nb().getHeight();
                                    int width = aVar.nb().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gsx.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gsu.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gsu.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gsu.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gsu.getLayoutParams().height = FormCardView.this.bbG;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gsx.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.pc(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gsu);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gsu.setImageBitmap(null);
                                FormCardView.this.gsu.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gsu.setImageBitmap(null);
                                FormCardView.this.gsu.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gsu.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gsu.setVisibility(8);
    }

    private void bnU() {
        FormCard.f fVar = this.gsx.resultInfo;
        float dimension = this.mContext.getResources().getDimension(f.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(f.e.fontsize28);
        int color = this.mContext.getResources().getColor(f.d.form_font_color);
        if (fVar != null) {
            this.gsv.setText(fVar.title);
            this.gsv.setTextColor(-1);
            this.gsv.setTextSize(0, dimension);
            this.gsw.setText(fVar.desc);
            this.gsw.setTextColor(color);
            this.gsw.setTextSize(0, dimension2);
        }
    }

    private void bnV() {
        if (this.gsx.itemList != null && this.gsx.itemList.size() > 0) {
            int size = this.gsx.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gsx.itemList.get(i);
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

    private void bnW() {
        this.gst.removeAllViews();
        if (this.gsy != null) {
            this.gsy.clear();
        } else {
            this.gsy = new ArrayList();
        }
        this.gsr.setVisibility(0);
        this.gst.setVisibility(0);
        this.gss.setVisibility(8);
        this.gsr.setClickable(true);
        this.gsu.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aB(this.gsA);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gst.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bnY());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(f.e.form_size40)) * this.gsA);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bnY()));
        }
    }

    public void a(a aVar) {
        if (this.gsy == null) {
            this.gsy = new ArrayList();
        }
        this.gsy.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bZ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bnP()) {
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
                    if (formView2 != null && (bZ = bZ(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(bZ);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gsr.setClickable(false);
                return;
            }
            new d().showToast(f.C0146f.icon_toast_game_error, f.j.form_commit_error_string);
            this.gsr.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnX() {
        this.gsr.setVisibility(4);
        this.gst.setVisibility(4);
        this.gss.setVisibility(0);
    }

    private JSONObject bZ(String str, String str2) {
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
            this.gsr.setClickable(true);
        } else {
            b.bnp().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.ZR) {
                            FormCardView.this.gsx.setCommitState(true);
                            FormCardView.this.bnX();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new d().f(hVar.errorString);
                            FormCardView.this.gsx.setCommitState(false);
                        } else {
                            new d().showToast(f.C0146f.icon_toast_game_error, f.j.form_commit_fail_string);
                            FormCardView.this.gsx.setCommitState(false);
                        }
                    }
                    FormCardView.this.gsr.setClickable(true);
                }
            });
        }
    }
}
