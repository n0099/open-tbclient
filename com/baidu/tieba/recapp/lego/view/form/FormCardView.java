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
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.e;
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
    private int bjq;
    private TitleView gHl;
    private CommitView gHm;
    private LinearLayout gHn;
    private LinearLayout gHo;
    private ImageView gHp;
    private TextView gHq;
    private TextView gHr;
    private FormCard gHs;
    private List<a> gHt;
    private String gHu;
    private float gHv;
    private int gHw;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean btL();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHu = "";
        this.mScreenWidth = 0;
        this.bjq = 0;
        this.gHv = 1.0f;
        this.gHw = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWW() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gHl = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gHp = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gHp.setEnabled(false);
        this.gHm = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gHo = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gHn = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gHq = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gHr = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gHm != null) {
            this.gHm.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gHt, FormCardView.this.gHm.getPostUrl(), FormCardView.this.gHu);
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
        if (formCard != null && formCard.mIsLegal && this.gHs != formCard) {
            btS();
            this.gHs = formCard;
            this.gHu = formCard.getItemId();
            bG(formCard.mWidth, formCard.mHeight);
            this.gHl.aw(this.gHv);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gHl.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0175e.form_size90)) * this.gHv);
            }
            this.gHm.aw(this.gHv);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gHm.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0175e.form_size90)) * this.gHv);
            }
            this.gHl.a(formCard.titleInfo);
            this.gHm.a(formCard.commitInfo);
            b.btl().a(new com.baidu.tieba.recapp.a.a(this.gHm.getPostUrl()));
            btP();
            btR();
            btQ();
            a(this.gHl);
            a(this.gHm);
            if (formCard.isCommitSuccess()) {
                btT();
            }
            if (!formCard.mHasShown) {
                r.btk().btg().aR(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bG(int i, int i2) {
        this.bjq = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bjq;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gHv = (float) (this.mScreenWidth / 750.0d);
    }

    private void btP() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gHs.backgroundInfo != null) {
            this.gHp.setVisibility(0);
            if (!TextUtils.isEmpty(this.gHs.backgroundInfo.img)) {
                c.jC().a(this.gHs.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.os() != null) {
                                    int height = aVar.os().getHeight();
                                    int width = aVar.os().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gHs.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gHp.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gHp.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gHp.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gHp.getLayoutParams().height = FormCardView.this.bjq;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gHs.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.qe(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gHp);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gHp.setImageBitmap(null);
                                FormCardView.this.gHp.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gHp.setImageBitmap(null);
                                FormCardView.this.gHp.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gHp.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gHp.setVisibility(8);
    }

    private void btQ() {
        FormCard.f fVar = this.gHs.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0175e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0175e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gHq.setText(fVar.title);
            this.gHq.setTextColor(-1);
            this.gHq.setTextSize(0, dimension);
            this.gHr.setText(fVar.desc);
            this.gHr.setTextColor(color);
            this.gHr.setTextSize(0, dimension2);
        }
    }

    private void btR() {
        if (this.gHs.itemList != null && this.gHs.itemList.size() > 0) {
            int size = this.gHs.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gHs.itemList.get(i);
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

    private void btS() {
        this.gHo.removeAllViews();
        if (this.gHt != null) {
            this.gHt.clear();
        } else {
            this.gHt = new ArrayList();
        }
        this.gHm.setVisibility(0);
        this.gHo.setVisibility(0);
        this.gHn.setVisibility(8);
        this.gHm.setClickable(true);
        this.gHp.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aw(this.gHv);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gHo.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.btU());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0175e.form_size40)) * this.gHv);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.btU()));
        }
    }

    public void a(a aVar) {
        if (this.gHt == null) {
            this.gHt = new ArrayList();
        }
        this.gHt.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject cu;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.btL()) {
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
                    if (formView2 != null && (cu = cu(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(cu);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gHm.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gHm.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btT() {
        this.gHm.setVisibility(4);
        this.gHo.setVisibility(4);
        this.gHn.setVisibility(0);
    }

    private JSONObject cu(String str, String str2) {
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
            this.gHm.setClickable(true);
        } else {
            b.btl().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.ahs) {
                            FormCardView.this.gHs.setCommitState(true);
                            FormCardView.this.btT();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gHs.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gHs.setCommitState(false);
                        }
                    }
                    FormCardView.this.gHm.setClickable(true);
                }
            });
        }
    }
}
