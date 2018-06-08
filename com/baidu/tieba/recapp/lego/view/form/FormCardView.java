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
    private int baD;
    private TitleView gnk;
    private CommitView gnl;
    private LinearLayout gnm;
    private LinearLayout gnn;
    private ImageView gno;
    private TextView gnp;
    private TextView gnq;
    private FormCard gnr;
    private List<a> gns;
    private String gnt;
    private float gnu;
    private int gnv;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean boJ();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gnt = "";
        this.mScreenWidth = 0;
        this.baD = 0;
        this.gnu = 1.0f;
        this.gnv = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aPQ() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.i.card_form, (ViewGroup) null);
        this.gnk = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.gno = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gno.setEnabled(false);
        this.gnl = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.gnn = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gnm = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gnp = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gnq = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gnl != null) {
            this.gnl.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.b(FormCardView.this.gns, FormCardView.this.gnl.getPostUrl(), FormCardView.this.gnt);
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
        if (formCard != null && formCard.mIsLegal && this.gnr != formCard) {
            boQ();
            this.gnr = formCard;
            this.gnt = formCard.getItemId();
            bB(formCard.mWidth, formCard.mHeight);
            this.gnk.aB(this.gnu);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gnk.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gnu);
            }
            this.gnl.aB(this.gnu);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gnl.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gnu);
            }
            this.gnk.a(formCard.titleInfo);
            this.gnl.a(formCard.commitInfo);
            b.bok().a(new com.baidu.tieba.recapp.a.a(this.gnl.getPostUrl()));
            boN();
            boP();
            boO();
            a(this.gnk);
            a(this.gnl);
            if (formCard.isCommitSuccess()) {
                boR();
            }
            if (!formCard.mHasShown) {
                r.boj().bof().aD(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bB(int i, int i2) {
        this.baD = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.baD;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gnu = (float) (this.mScreenWidth / 750.0d);
    }

    private void boN() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gnr.backgroundInfo != null) {
            this.gno.setVisibility(0);
            if (!TextUtils.isEmpty(this.gnr.backgroundInfo.img)) {
                c.ig().a(this.gnr.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.gnr.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gno.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gno.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gno.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gno.getLayoutParams().height = FormCardView.this.baD;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gnr.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.oG(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gno);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gno.setImageBitmap(null);
                                FormCardView.this.gno.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gno.setImageBitmap(null);
                                FormCardView.this.gno.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gno.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gno.setVisibility(8);
    }

    private void boO() {
        FormCard.f fVar = this.gnr.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0141d.form_font_color);
        if (fVar != null) {
            this.gnp.setText(fVar.title);
            this.gnp.setTextColor(-1);
            this.gnp.setTextSize(0, dimension);
            this.gnq.setText(fVar.desc);
            this.gnq.setTextColor(color);
            this.gnq.setTextSize(0, dimension2);
        }
    }

    private void boP() {
        if (this.gnr.itemList != null && this.gnr.itemList.size() > 0) {
            int size = this.gnr.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gnr.itemList.get(i);
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

    private void boQ() {
        this.gnn.removeAllViews();
        if (this.gns != null) {
            this.gns.clear();
        } else {
            this.gns = new ArrayList();
        }
        this.gnl.setVisibility(0);
        this.gnn.setVisibility(0);
        this.gnm.setVisibility(8);
        this.gnl.setClickable(true);
        this.gno.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aB(this.gnu);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gnn.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.boS());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gnu);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.boS()));
        }
    }

    public void a(a aVar) {
        if (this.gns == null) {
            this.gns = new ArrayList();
        }
        this.gns.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bY;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.boJ()) {
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
                    if (formView2 != null && (bY = bY(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(bY);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gnl.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(d.f.icon_toast_game_error, d.k.form_commit_error_string);
            this.gnl.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boR() {
        this.gnl.setVisibility(4);
        this.gnn.setVisibility(4);
        this.gnm.setVisibility(0);
    }

    private JSONObject bY(String str, String str2) {
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
            this.gnl.setClickable(true);
        } else {
            b.bok().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.aaj) {
                            FormCardView.this.gnr.setCommitState(true);
                            FormCardView.this.boR();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().j(hVar.errorString);
                            FormCardView.this.gnr.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(d.f.icon_toast_game_error, d.k.form_commit_fail_string);
                            FormCardView.this.gnr.setCommitState(false);
                        }
                    }
                    FormCardView.this.gnl.setClickable(true);
                }
            });
        }
    }
}
