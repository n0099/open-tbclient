package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools Qj;
    private int Qk;
    private boolean aND;
    private boolean aNE;
    private boolean aNF;
    private int aNG;
    private EditText aOg;
    private LinearLayout aOk;
    private int azP;
    private ImageView hmN;
    private View mBottomLine;
    private TextView mSendView;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aND = false;
        this.aNE = true;
        this.aNF = true;
        this.aNG = -1;
        this.azP = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.tbds144));
        this.aOk = new LinearLayout(getContext());
        this.aOk.setOrientation(0);
        this.aOk.setMinimumHeight(com.baidu.adp.lib.util.l.e(context, d.e.ds90));
        addView(this.aOk, new LinearLayout.LayoutParams(-1, -2));
        cn(context);
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cn(Context context) {
        this.hmN = new ImageView(context);
        this.hmN.setEnabled(true);
        this.hmN.setPadding(0, 0, com.baidu.adp.lib.util.l.e(context, d.e.tbds30), com.baidu.adp.lib.util.l.e(context, d.e.tbds24));
        this.hmN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aOk.addView(this.hmN, layoutParams);
    }

    private void bc(Context context) {
        this.aOg = new EditText(context);
        this.aOg.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aOg.setMaxLines(4);
        this.aOg.setGravity(16);
        this.aOg.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aOg.setBackgroundResource(d.C0142d.common_color_10022);
        a(this.aOg, d.f.edittext_cursor);
        this.aOg.setPadding(0, com.baidu.adp.lib.util.l.e(context, d.e.ds24), com.baidu.adp.lib.util.l.e(context, d.e.ds54), com.baidu.adp.lib.util.l.e(context, d.e.ds24));
        this.aOg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aOg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aNF) {
                    VideoPlayInputContainer.this.aNF = true;
                    if (VideoPlayInputContainer.this.aNG != -1) {
                        VideoPlayInputContainer.this.aOg.setSelection(VideoPlayInputContainer.this.aNG);
                        VideoPlayInputContainer.this.aNG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aOg.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bFu();
            }
        });
        this.aOg.setHint(context.getString(d.k.reply_something));
        this.aOg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aOg.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aOk.addView(this.aOg, layoutParams);
    }

    private void a(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void bb(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.k.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.e(context, d.e.tbds18));
        layoutParams.gravity = 80;
        this.aOk.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aOg.getSelectionStart() > 0) {
                        String substring = this.aOg.getText().toString().substring(0, this.aOg.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cSw.matcher(substring);
                        if (matcher.find()) {
                            this.aOg.getText().delete(this.aOg.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aOg.getSelectionStart());
                            return;
                        }
                        this.aOg.getText().delete(this.aOg.getSelectionStart() - 1, this.aOg.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aOg.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aOg.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aOg.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aOg.setSelection(VideoPlayInputContainer.this.aOg.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aOg.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bFu();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof n)) {
                        n nVar = (n) aVar.data;
                        if (nVar.Ct() == EmotionGroupType.NET_SUG) {
                            a(nVar);
                            return;
                        } else {
                            b(nVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aOg.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lB(obj) >= 10 && getContext() != null) {
                e.ym().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aOg);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aND || nVar.Ct() == EmotionGroupType.LOCAL) {
            String obj = this.aOg.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lB(obj) >= 10 && getContext() != null) {
                e.ym().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aOg);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.aOg != null) {
            this.aOg.setFocusable(true);
            this.aOg.setFocusableInTouchMode(true);
            this.aOg.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aOg);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.azP = i;
        am.j(this.mBottomLine, d.C0142d.cp_bg_line_c);
        am.b(this.aOg, d.C0142d.cp_cont_f, 2, i);
        am.j(this, d.C0142d.cp_bg_line_d);
        if (i == 0) {
            a(this.aOg, d.f.edittext_cursor);
            this.aOg.setHintTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_d));
        } else {
            a(this.aOg, d.f.edittext_cursor_1);
            this.aOg.setHintTextColor(am.getColor(i, d.C0142d.cp_cont_d));
        }
        bFu();
        am.c(this.hmN, d.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFu() {
        if (this.mSendView.isEnabled()) {
            am.b(this.mSendView, d.C0142d.cp_link_tip_a, 1, this.azP);
        } else {
            am.c(this.mSendView, d.C0142d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aOg;
    }
}
