package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
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
/* loaded from: classes20.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aOH;
    private TitleView lGf;
    private CommitView lGg;
    private LinearLayout lGh;
    private LinearLayout lGi;
    private ImageView lGj;
    private TextView lGk;
    private TextView lGl;
    private FormCard lGm;
    private List<a> lGn;
    private float lGo;
    private int lGp;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes20.dex */
    public interface a {
        boolean dnI();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aOH = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.lGo = 1.0f;
        this.lGp = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMp() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.lGf = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.lGj = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.lGj.setEnabled(false);
        this.lGg = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.lGi = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.lGh = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.lGk = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.lGl = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.lGg != null) {
            this.lGg.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.lGn, FormCardView.this.lGg.getPostUrl(), FormCardView.this.aOH);
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
    public void d(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.lGm != formCard) {
            dnP();
            this.lGm = formCard;
            this.aOH = formCard.getItemId();
            dd(formCard.mWidth, formCard.mHeight);
            this.lGf.aC(this.lGo);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGf.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lGo);
            }
            this.lGg.aC(this.lGo);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lGg.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lGo);
            }
            this.lGf.a(formCard.titleInfo);
            this.lGg.a(formCard.commitInfo);
            b.dni().a(new com.baidu.tieba.recapp.a.a(this.lGg.getPostUrl()));
            dnM();
            dnO();
            dnN();
            a(this.lGf);
            a(this.lGg);
            if (formCard.isCommitSuccess()) {
                dnQ();
            }
            if (!formCard.mHasShown) {
                r.dnh().dnd().dN(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dd(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.lGo = (float) (this.mScreenWidth / 750.0d);
    }

    private void dnM() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.lGm.backgroundInfo != null) {
            this.lGj.setVisibility(0);
            if (!TextUtils.isEmpty(this.lGm.backgroundInfo.img)) {
                c.mM().a(this.lGm.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.lGm.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.lGj.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lGj.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.lGj.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lGj.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int fn = com.baidu.tieba.lego.card.d.b.fn(FormCardView.this.lGm.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Cn(fn)) {
                                            FormCardView.this.mRootView.setBackgroundColor(fn);
                                        }
                                        aVar.drawImageTo(FormCardView.this.lGj);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.lGj.setImageBitmap(null);
                                FormCardView.this.lGj.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.lGj.setImageBitmap(null);
                                FormCardView.this.lGj.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.lGj.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.lGj.setVisibility(8);
    }

    private void dnN() {
        FormCard.f fVar = this.lGm.resultInfo;
        float dimension = this.efn.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.efn.getResources().getDimension(R.dimen.fontsize28);
        int color = this.efn.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.lGk.setText(fVar.title);
            this.lGk.setTextColor(-1);
            this.lGk.setTextSize(0, dimension);
            this.lGl.setText(fVar.desc);
            this.lGl.setTextColor(color);
            this.lGl.setTextSize(0, dimension2);
        }
    }

    private void dnO() {
        if (this.lGm.itemList != null && this.lGm.itemList.size() > 0) {
            int size = this.lGm.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.lGm.itemList.get(i);
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

    private void dnP() {
        this.lGi.removeAllViews();
        if (this.lGn != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.lGn);
        } else {
            this.lGn = new ArrayList();
        }
        this.lGg.setVisibility(0);
        this.lGi.setVisibility(0);
        this.lGh.setVisibility(8);
        this.lGg.setClickable(true);
        this.lGj.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aC(this.lGo);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.lGi.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dnR());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.lGo);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dnR()));
        }
    }

    public void a(a aVar) {
        if (this.lGn == null) {
            this.lGn = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.lGn, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fE;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dnI()) {
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
                    if (formView2 != null && (fE = fE(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fE);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.lGg.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.lGg.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnQ() {
        this.lGg.setVisibility(4);
        this.lGi.setVisibility(4);
        this.lGh.setVisibility(0);
    }

    private JSONObject fE(String str, String str2) {
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

    private void e(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.lGg.setClickable(true);
        } else {
            b.dni().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.lGm.setCommitState(true);
                            FormCardView.this.dnQ();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.lGm.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.lGm.setCommitState(false);
                        }
                    }
                    FormCardView.this.lGg.setClickable(true);
                }
            });
        }
    }
}
