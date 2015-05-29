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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern cqQ = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern cqU = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean ale;
    private int cqL;
    private ab cqM;
    protected PbEditorToolView cqN;
    public EditorToolComponetContainer cqO;
    protected com.baidu.tbadk.editortool.v cqP;
    private boolean cqR;
    private final CustomMessageListener cqS;
    protected boolean cqT;
    private boolean cqw;
    protected Context mContext;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.ale = z;
        if (this.cqO != null) {
            this.cqO.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.cqO;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.cqN;
    }

    public PbEditor(Context context) {
        super(context);
        this.cqL = 1000;
        this.cqw = false;
        this.ale = false;
        this.cqS = new q(this, 2001310);
        this.cqT = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqL = 1000;
        this.cqw = false;
        this.ale = false;
        this.cqS = new q(this, 2001310);
        this.cqT = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public void setFrom(int i) {
        if (this.cqO != null) {
            this.cqO.setFrom(i);
        }
    }

    public void anO() {
        this.cqN.anO();
    }

    public void anP() {
        this.cqN.anP();
    }

    public boolean anQ() {
        Editable text = this.cqN.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.cqO.anF() || this.cqO.anG()) {
            return true;
        }
        return this.cqO.anH();
    }

    public EditText getEditText() {
        return this.cqN.getEditText();
    }

    public void u(ArrayList<String> arrayList) {
        this.cqN.T(arrayList);
    }

    public String getContent() {
        return this.cqN.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.cqN.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.cqN.getEditText().setSelection(str.length());
        }
    }

    public void anR() {
        this.cqN.getEditText().requestFocus();
        this.cqO.ab(this.cqN.getEditText());
    }

    public void anS() {
        this.cqO.hideAll();
        this.cqN.ane();
    }

    public void anT() {
        this.cqO.hideAll();
        this.cqN.ane();
    }

    public void anU() {
        if (this.cqO.anw() && !this.cqR) {
            this.cqR = true;
            ac.a(this, this.mContext, new r(this));
            return;
        }
        anS();
    }

    public boolean anw() {
        return this.cqO.anw();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_editor_view, this, true);
        this.cqN = (PbEditorToolView) findViewById(com.baidu.tieba.q.pb_editor_tool_button);
        this.cqO = (EditorToolComponetContainer) findViewById(com.baidu.tieba.q.pb_editor_tool_group);
        anV();
        MessageManager.getInstance().unRegisterListener(this.mId);
        this.cqS.setTag(this.mId);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cqS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cqS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anV() {
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void anW() {
        this.cqM = new ab(this.mContext);
        this.cqM.uy();
        addView(this.cqM, 0);
        this.cqM.setOnActionListener(this.cqP);
    }

    public boolean anK() {
        return this.cqO.anK();
    }

    public void Z(View view) {
        this.cqO.Z(view);
    }

    public void aa(View view) {
        this.cqO.aa(view);
    }

    public void adc() {
        this.cqN.getEditText().requestFocus();
        this.cqO.ab(this.cqN.getEditText());
        this.cqN.getEditText().setSelection(this.cqN.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ae aeVar) {
        this.cqN.getEditText().requestFocus();
        this.cqO.aa(this.cqN.getEditText());
        iM(i);
    }

    public void D(int i, String str) {
        if (this.cqM != null) {
            this.cqM.D(i, str);
            if (i == 2 && this.cqM.getVisibility() == 0) {
                this.cqO.zN();
                this.cqN.aod();
                return;
            }
            anX();
        }
    }

    private void anX() {
        if (this.cqO != null) {
            this.cqO.zO();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        D(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.cqM == null) {
            return 8;
        }
        return this.cqM.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.cqM == null) {
            return 0;
        }
        return this.cqM.getLocationInfoViewState();
    }

    protected void iM(int i) {
        if (i == 5) {
            this.cqO.anB();
        } else if (i == 23 || i == 22) {
            this.cqO.anC();
        } else if (i == 2) {
            this.cqO.anA();
        } else if (i == 38) {
            this.cqO.anz();
        } else if (i == 44) {
            this.cqO.anD();
        } else if (i == 50 || i == 48) {
            this.cqO.anE();
        }
    }

    public void iN(int i) {
        if (this.cqO.anw()) {
            iM(i);
            this.cqO.aa(this.cqN.getEditText());
            return;
        }
        this.cqT = false;
        if (this.cqO.anK()) {
            this.cqO.aa(this.cqN.getEditText());
        }
        new Handler().postDelayed(new s(this, i), 200L);
    }

    public boolean Km() {
        Editable text = this.cqN.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.cqL;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.v vVar) {
        this.mPageContext = tbPageContext;
        if (vVar != null) {
            this.cqP = vVar;
            if (this.cqM != null) {
                this.cqM.setOnActionListener(vVar);
            }
            this.cqN.setOnActionListener(new u(this, vVar));
            this.cqO.setOnActionListener(new v(this, vVar));
        }
    }

    public void anI() {
        this.cqO.anI();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().j(this.cqN);
            tbPageContext.getLayoutMode().j(this.cqO);
        }
        if (this.cqM != null) {
            this.cqM.uy();
        }
        this.cqN.changeSkinType(i);
        this.cqO.onChangeSkinType(i);
    }

    public void clearData() {
        this.cqN.clearData();
        this.cqO.clearData();
    }

    public void any() {
        this.cqO.any();
    }

    public void CQ() {
        if (this.cqP != null) {
            this.cqP.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.cqP != null) {
            this.cqP.handleAction(34, null);
        }
        this.cqN.ane();
        this.cqO.hideAll();
        aa(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.cqN.setMoreFocusable(z);
    }

    public void ack() {
        if (this.cqO.cqf != null) {
            this.cqO.cqf.setHasAudio(false);
        }
    }

    public void acl() {
        if (this.cqO.cqf != null) {
            this.cqO.cqf.setHasAudio(true);
        }
    }

    public void Kr() {
        this.cqO.Kr();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.cqO.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.cqO.setAudioData(voiceModel);
    }

    public void Kq() {
        this.cqO.Kq();
    }

    public void abZ() {
        this.cqO.zR();
    }

    public void k(Bitmap bitmap) {
        this.cqO.setImage(bitmap);
    }

    public void aX(boolean z) {
        this.cqw = z;
        this.cqO.aX(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int jz(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = cqU.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.zE().ex(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.cqw) {
            this.cqN.aoe();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cqw) {
            if (!this.cqO.anF() && !this.cqO.anG() && !this.cqO.zM()) {
                this.cqN.aoe();
            } else {
                this.cqN.aod();
            }
        } else {
            this.cqN.aod();
        }
        this.cqO.refresh();
    }

    public void setMaxTextCount(int i) {
        this.cqL = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.cqM == null) {
                anW();
            }
            this.cqM.setVisibility(0);
            return;
        }
        if (this.cqM != null) {
            removeView(this.cqM);
            this.cqM = null;
        }
        anX();
    }
}
