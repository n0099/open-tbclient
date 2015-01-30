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
    private static final Pattern bWm = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern bWp = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean Zs;
    private boolean bVU;
    private int bWh;
    private ak bWi;
    protected PbEditorToolView bWj;
    public EditorToolComponetContainer bWk;
    protected com.baidu.tbadk.editortool.w bWl;
    private boolean bWn;
    protected boolean bWo;
    protected Context mContext;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.Zs = z;
        if (this.bWk != null) {
            this.bWk.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.bWk;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.bWj;
    }

    public PbEditor(Context context) {
        super(context);
        this.bWh = 1000;
        this.bVU = false;
        this.Zs = false;
        this.bWo = true;
        this.mContext = context;
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWh = 1000;
        this.bVU = false;
        this.Zs = false;
        this.bWo = true;
        this.mContext = context;
        initialize();
    }

    public void setFrom(int i) {
        if (this.bWk != null) {
            this.bWk.setFrom(i);
        }
    }

    public void agf() {
        this.bWj.agf();
    }

    public void agg() {
        this.bWj.agg();
    }

    public boolean agh() {
        Editable text = this.bWj.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.bWk.afW() || this.bWk.afX()) {
            return true;
        }
        return this.bWk.afY();
    }

    public EditText getEditText() {
        return this.bWj.getEditText();
    }

    public void A(ArrayList<String> arrayList) {
        this.bWj.P(arrayList);
    }

    public String getContent() {
        return this.bWj.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.bWj.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.bWj.getEditText().setSelection(str.length());
        }
    }

    public void agi() {
        this.bWj.getEditText().requestFocus();
        this.bWk.X(this.bWj.getEditText());
    }

    public void agj() {
        this.bWk.hideAll();
        this.bWj.afw();
    }

    public void agk() {
        this.bWk.hideAll();
        this.bWj.afw();
    }

    public void agl() {
        if (this.bWk.afN() && !this.bWn) {
            this.bWn = true;
            ay.a(this, this.mContext, new aa(this));
            return;
        }
        agj();
    }

    public boolean afN() {
        return this.bWk.afN();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.pb_editor_view, this, true);
        this.bWj = (PbEditorToolView) findViewById(com.baidu.tieba.w.pb_editor_tool_button);
        this.bWk = (EditorToolComponetContainer) findViewById(com.baidu.tieba.w.pb_editor_tool_group);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void agm() {
        this.bWi = new ak(this.mContext);
        this.bWi.qL();
        addView(this.bWi, 0);
        this.bWi.setOnActionListener(this.bWl);
    }

    public boolean agb() {
        return this.bWk.agb();
    }

    public void V(View view) {
        this.bWk.V(view);
    }

    public void W(View view) {
        this.bWk.W(view);
    }

    public void aae() {
        this.bWj.getEditText().requestFocus();
        this.bWk.X(this.bWj.getEditText());
        this.bWj.getEditText().setSelection(this.bWj.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ba baVar) {
        this.bWj.getEditText().requestFocus();
        this.bWk.W(this.bWj.getEditText());
        hP(i);
    }

    public void B(int i, String str) {
        if (this.bWi != null) {
            this.bWi.B(i, str);
            if (i == 2 && this.bWi.getVisibility() == 0) {
                this.bWk.vC();
                this.bWj.agt();
                return;
            }
            agn();
        }
    }

    private void agn() {
        if (this.bWk != null) {
            this.bWk.vD();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.bWi == null) {
            return 8;
        }
        return this.bWi.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.bWi == null) {
            return 0;
        }
        return this.bWi.getLocationInfoViewState();
    }

    protected void hP(int i) {
        if (i == 5) {
            this.bWk.afS();
        } else if (i == 23 || i == 22) {
            this.bWk.afT();
        } else if (i == 2) {
            this.bWk.afR();
        } else if (i == 38) {
            this.bWk.afQ();
        } else if (i == 44) {
            this.bWk.afU();
        } else if (i == 50 || i == 48) {
            this.bWk.afV();
        }
    }

    public void hQ(int i) {
        if (this.bWk.afN()) {
            hP(i);
            this.bWk.W(this.bWj.getEditText());
            return;
        }
        this.bWo = false;
        if (this.bWk.agb()) {
            this.bWk.W(this.bWj.getEditText());
        }
        new Handler().postDelayed(new ab(this, i), 200L);
    }

    public boolean FJ() {
        Editable text = this.bWj.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.bWh;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.w wVar) {
        this.mPageContext = tbPageContext;
        if (wVar != null) {
            this.bWl = wVar;
            if (this.bWi != null) {
                this.bWi.setOnActionListener(wVar);
            }
            this.bWj.setOnActionListener(new ad(this, wVar));
            this.bWk.setOnActionListener(new ae(this, wVar));
        }
    }

    public void afZ() {
        this.bWk.afZ();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(this.bWj);
            tbPageContext.getLayoutMode().h(this.bWk);
        }
        if (this.bWi != null) {
            this.bWi.qL();
        }
        this.bWj.changeSkinType(i);
        this.bWk.onChangeSkinType(i);
    }

    public void clearData() {
        this.bWj.clearData();
        this.bWk.clearData();
    }

    public void afP() {
        this.bWk.afP();
    }

    public void yR() {
        if (this.bWl != null) {
            this.bWl.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.bWl != null) {
            this.bWl.handleAction(34, null);
        }
        this.bWj.afw();
        this.bWk.hideAll();
        W(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.bWj.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.bWj.setAudioFocusable(z);
    }

    public void YT() {
        this.bWj.YT();
    }

    public void YU() {
        this.bWj.YU();
    }

    public void FO() {
        this.bWk.FO();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.bWk.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.bWk.setAudioData(voiceModel);
    }

    public void FN() {
        this.bWk.FN();
    }

    public void j(Bitmap bitmap) {
        this.bWk.setImage(bitmap);
    }

    public void aK(boolean z) {
        this.bVU = z;
        this.bWk.aK(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int ik(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = bWp.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.ab.vt().dU(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.bVU) {
            this.bWj.agu();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble()) && !this.bVU) {
            if (!this.bWk.afW() && !this.bWk.afX() && !this.bWk.vB()) {
                this.bWj.agu();
            } else {
                this.bWj.agt();
            }
        } else {
            this.bWj.agt();
        }
        this.bWk.refresh();
    }

    public void setMaxTextCount(int i) {
        this.bWh = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.bWi == null) {
                agm();
            }
            this.bWi.setVisibility(0);
            return;
        }
        if (this.bWi != null) {
            removeView(this.bWi);
            this.bWi = null;
        }
        agn();
    }
}
