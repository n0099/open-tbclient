package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern bWl = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern bWo = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean Zp;
    private boolean bVT;
    private int bWg;
    private ak bWh;
    protected PbEditorToolView bWi;
    public EditorToolComponetContainer bWj;
    protected com.baidu.tbadk.editortool.w bWk;
    private boolean bWm;
    protected boolean bWn;
    protected Context mContext;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.Zp = z;
        if (this.bWj != null) {
            this.bWj.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.bWj;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.bWi;
    }

    public PbEditor(Context context) {
        super(context);
        this.bWg = 1000;
        this.bVT = false;
        this.Zp = false;
        this.bWn = true;
        this.mContext = context;
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWg = 1000;
        this.bVT = false;
        this.Zp = false;
        this.bWn = true;
        this.mContext = context;
        initialize();
    }

    public void setFrom(int i) {
        if (this.bWj != null) {
            this.bWj.setFrom(i);
        }
    }

    public void aga() {
        this.bWi.aga();
    }

    public void agb() {
        this.bWi.agb();
    }

    public boolean agc() {
        Editable text = this.bWi.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.bWj.afR() || this.bWj.afS()) {
            return true;
        }
        return this.bWj.afT();
    }

    public EditText getEditText() {
        return this.bWi.getEditText();
    }

    public void A(ArrayList<String> arrayList) {
        this.bWi.P(arrayList);
    }

    public String getContent() {
        return this.bWi.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.bWi.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.bWi.getEditText().setSelection(str.length());
        }
    }

    public void agd() {
        this.bWi.getEditText().requestFocus();
        this.bWj.X(this.bWi.getEditText());
    }

    public void age() {
        this.bWj.hideAll();
        this.bWi.afr();
    }

    public void agf() {
        this.bWj.hideAll();
        this.bWi.afr();
    }

    public void agg() {
        if (this.bWj.afI() && !this.bWm) {
            this.bWm = true;
            ay.a(this, this.mContext, new aa(this));
            return;
        }
        age();
    }

    public boolean afI() {
        return this.bWj.afI();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.pb_editor_view, this, true);
        this.bWi = (PbEditorToolView) findViewById(com.baidu.tieba.w.pb_editor_tool_button);
        this.bWj = (EditorToolComponetContainer) findViewById(com.baidu.tieba.w.pb_editor_tool_group);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void agh() {
        this.bWh = new ak(this.mContext);
        this.bWh.qF();
        addView(this.bWh, 0);
        this.bWh.setOnActionListener(this.bWk);
    }

    public boolean afW() {
        return this.bWj.afW();
    }

    public void V(View view) {
        this.bWj.V(view);
    }

    public void W(View view) {
        this.bWj.W(view);
    }

    public void ZZ() {
        this.bWi.getEditText().requestFocus();
        this.bWj.X(this.bWi.getEditText());
        this.bWi.getEditText().setSelection(this.bWi.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ba baVar) {
        this.bWi.getEditText().requestFocus();
        this.bWj.W(this.bWi.getEditText());
        hP(i);
    }

    public void B(int i, String str) {
        if (this.bWh != null) {
            this.bWh.B(i, str);
            if (i == 2 && this.bWh.getVisibility() == 0) {
                this.bWj.vw();
                this.bWi.ago();
                return;
            }
            agi();
        }
    }

    private void agi() {
        if (this.bWj != null) {
            this.bWj.vx();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.bWh == null) {
            return 8;
        }
        return this.bWh.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.bWh == null) {
            return 0;
        }
        return this.bWh.getLocationInfoViewState();
    }

    protected void hP(int i) {
        if (i == 5) {
            this.bWj.afN();
        } else if (i == 23 || i == 22) {
            this.bWj.afO();
        } else if (i == 2) {
            this.bWj.afM();
        } else if (i == 38) {
            this.bWj.afL();
        } else if (i == 44) {
            this.bWj.afP();
        } else if (i == 50 || i == 48) {
            this.bWj.afQ();
        }
    }

    public void hQ(int i) {
        if (this.bWj.afI()) {
            hP(i);
            this.bWj.W(this.bWi.getEditText());
            return;
        }
        this.bWn = false;
        if (this.bWj.afW()) {
            this.bWj.W(this.bWi.getEditText());
        }
        new Handler().postDelayed(new ab(this, i), 200L);
    }

    public boolean FD() {
        Editable text = this.bWi.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.bWg;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.w wVar) {
        this.mPageContext = tbPageContext;
        if (wVar != null) {
            this.bWk = wVar;
            if (this.bWh != null) {
                this.bWh.setOnActionListener(wVar);
            }
            this.bWi.setOnActionListener(new ad(this, wVar));
            this.bWj.setOnActionListener(new ae(this, wVar));
        }
    }

    public void afU() {
        this.bWj.afU();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(this.bWi);
            tbPageContext.getLayoutMode().h(this.bWj);
        }
        if (this.bWh != null) {
            this.bWh.qF();
        }
        this.bWi.changeSkinType(i);
        this.bWj.onChangeSkinType(i);
    }

    public void clearData() {
        this.bWi.clearData();
        this.bWj.clearData();
    }

    public void afK() {
        this.bWj.afK();
    }

    public void yL() {
        if (this.bWk != null) {
            this.bWk.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.bWk != null) {
            this.bWk.handleAction(34, null);
        }
        this.bWi.afr();
        this.bWj.hideAll();
        W(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.bWi.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.bWi.setAudioFocusable(z);
    }

    public void YO() {
        this.bWi.YO();
    }

    public void YP() {
        this.bWi.YP();
    }

    public void FI() {
        this.bWj.FI();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.bWj.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.bWj.setAudioData(voiceModel);
    }

    public void FH() {
        this.bWj.FH();
    }

    public void j(Bitmap bitmap) {
        this.bWj.setImage(bitmap);
    }

    public void aK(boolean z) {
        this.bVT = z;
        this.bWj.aK(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int ii(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = bWo.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.ab.vn().dR(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.bVT) {
            this.bWi.agp();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble()) && !this.bVT) {
            if (!this.bWj.afR() && !this.bWj.afS() && !this.bWj.vv()) {
                this.bWi.agp();
            } else {
                this.bWi.ago();
            }
        } else {
            this.bWi.ago();
        }
        this.bWj.refresh();
    }

    public void setMaxTextCount(int i) {
        this.bWg = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.bWh == null) {
                agh();
            }
            this.bWh.setVisibility(0);
            return;
        }
        if (this.bWh != null) {
            removeView(this.bWh);
            this.bWh = null;
        }
        agi();
    }
}
