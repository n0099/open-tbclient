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
import com.baidu.tbadk.core.util.ak;
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
    private EditorTools JS;
    private int JT;
    private EditText aEN;
    private LinearLayout aER;
    private boolean aEk;
    private boolean aEl;
    private boolean aEm;
    private int aEn;
    private int aqQ;
    private ImageView gWf;
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
        this.aEk = false;
        this.aEl = true;
        this.aEm = true;
        this.aEn = -1;
        this.aqQ = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.tbds144));
        this.aER = new LinearLayout(getContext());
        this.aER.setOrientation(0);
        this.aER.setMinimumHeight(com.baidu.adp.lib.util.l.e(context, d.e.ds90));
        addView(this.aER, new LinearLayout.LayoutParams(-1, -2));
        ce(context);
        aS(context);
        aR(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ce(Context context) {
        this.gWf = new ImageView(context);
        this.gWf.setEnabled(true);
        this.gWf.setPadding(0, 0, com.baidu.adp.lib.util.l.e(context, d.e.tbds30), com.baidu.adp.lib.util.l.e(context, d.e.tbds24));
        this.gWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aER.addView(this.gWf, layoutParams);
    }

    private void aS(Context context) {
        this.aEN = new EditText(context);
        this.aEN.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aEN.setMaxLines(4);
        this.aEN.setGravity(16);
        this.aEN.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aEN.setBackgroundResource(d.C0126d.common_color_10022);
        a(this.aEN, d.f.edittext_cursor);
        this.aEN.setPadding(0, com.baidu.adp.lib.util.l.e(context, d.e.ds24), com.baidu.adp.lib.util.l.e(context, d.e.ds54), com.baidu.adp.lib.util.l.e(context, d.e.ds24));
        this.aEN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aEN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aEm) {
                    VideoPlayInputContainer.this.aEm = true;
                    if (VideoPlayInputContainer.this.aEn != -1) {
                        VideoPlayInputContainer.this.aEN.setSelection(VideoPlayInputContainer.this.aEn);
                        VideoPlayInputContainer.this.aEn = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aEN.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bzR();
            }
        });
        this.aEN.setHint(context.getString(d.k.reply_something));
        this.aEN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aEN.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aER.addView(this.aEN, layoutParams);
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

    private void aR(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.k.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.e(context, d.e.tbds18));
        layoutParams.gravity = 80;
        this.aER.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aEN.getSelectionStart() > 0) {
                        String substring = this.aEN.getText().toString().substring(0, this.aEN.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cKi.matcher(substring);
                        if (matcher.find()) {
                            this.aEN.getText().delete(this.aEN.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aEN.getSelectionStart());
                            return;
                        }
                        this.aEN.getText().delete(this.aEN.getSelectionStart() - 1, this.aEN.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aEN.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aEN.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aEN.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aEN.setSelection(VideoPlayInputContainer.this.aEN.getText().length());
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
                        this.aEN.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bzR();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof n)) {
                        n nVar = (n) aVar.data;
                        if (nVar.yC() == EmotionGroupType.NET_SUG) {
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
            String obj = this.aEN.getText().toString();
            if (this.aEl && com.baidu.tieba.face.a.kW(obj) >= 10 && getContext() != null) {
                e.uB().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aEN);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aEk || nVar.yC() == EmotionGroupType.LOCAL) {
            String obj = this.aEN.getText().toString();
            if (this.aEl && com.baidu.tieba.face.a.kW(obj) >= 10 && getContext() != null) {
                e.uB().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aEN);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lN() {
        if (this.aEN != null) {
            this.aEN.setFocusable(true);
            this.aEN.setFocusableInTouchMode(true);
            this.aEN.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aEN);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aqQ = i;
        ak.j(this.mBottomLine, d.C0126d.cp_bg_line_c);
        ak.b(this.aEN, d.C0126d.cp_cont_f, 2, i);
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (i == 0) {
            a(this.aEN, d.f.edittext_cursor);
            this.aEN.setHintTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_d));
        } else {
            a(this.aEN, d.f.edittext_cursor_1);
            this.aEN.setHintTextColor(ak.getColor(i, d.C0126d.cp_cont_d));
        }
        bzR();
        ak.c(this.gWf, d.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzR() {
        if (this.mSendView.isEnabled()) {
            ak.b(this.mSendView, d.C0126d.cp_link_tip_a, 1, this.aqQ);
        } else {
            ak.c(this.mSendView, d.C0126d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aEN;
    }
}
