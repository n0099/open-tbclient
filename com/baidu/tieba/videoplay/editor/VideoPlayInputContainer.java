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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools CJ;
    private int CK;
    private TextView asQ;
    private boolean cFN;
    private boolean cFO;
    private boolean cFP;
    private int cFQ;
    private EditText cGr;
    private LinearLayout cGv;
    private int csg;
    private ImageView fxv;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFN = false;
        this.cFO = true;
        this.cFP = true;
        this.cFQ = -1;
        this.csg = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.cGv = new LinearLayout(getContext());
        this.cGv.setOrientation(0);
        this.cGv.setMinimumHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds90));
        addView(this.cGv, new LinearLayout.LayoutParams(-1, -2));
        ei(context);
        cA(context);
        cz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ei(Context context) {
        this.fxv = new ImageView(context);
        this.fxv.setEnabled(true);
        this.fxv.setPadding(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24));
        this.fxv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.cGv.addView(this.fxv, layoutParams);
    }

    private void cA(Context context) {
        this.cGr = new EditText(context);
        this.cGr.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cGr.setMaxLines(4);
        this.cGr.setGravity(16);
        this.cGr.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cGr.setBackgroundResource(R.color.common_color_10022);
        e(this.cGr, R.drawable.edittext_cursor);
        this.cGr.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds54), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24));
        this.cGr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cGr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.cFP) {
                    VideoPlayInputContainer.this.cFP = true;
                    if (VideoPlayInputContainer.this.cFQ != -1) {
                        VideoPlayInputContainer.this.cGr.setSelection(VideoPlayInputContainer.this.cFQ);
                        VideoPlayInputContainer.this.cFQ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.cGr.getText().toString()));
                }
                VideoPlayInputContainer.this.asQ.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cwD();
            }
        });
        this.cGr.setHint(context.getString(R.string.reply_something));
        this.cGr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.cGr.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.cGv.addView(this.cGr, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void cz(Context context) {
        this.asQ = new TextView(context);
        this.asQ.setGravity(17);
        this.asQ.setIncludeFontPadding(false);
        this.asQ.setEnabled(false);
        this.asQ.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.asQ.setText(R.string.replay);
        this.asQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.cGv.addView(this.asQ, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cGr.getSelectionStart() > 0) {
                        String substring = this.cGr.getText().toString().substring(0, this.cGr.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fgF.matcher(substring);
                        if (matcher.find()) {
                            this.cGr.getText().delete(this.cGr.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cGr.getSelectionStart());
                            return;
                        }
                        this.cGr.getText().delete(this.cGr.getSelectionStart() - 1, this.cGr.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.cGr.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cGr.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.cGr.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.cGr.setSelection(VideoPlayInputContainer.this.cGr.getText().length());
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
                        this.cGr.setText((CharSequence) null);
                    }
                    this.asQ.setEnabled(false);
                    cwD();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.apk() == EmotionGroupType.NET_SUG) {
                            a(pVar);
                            return;
                        } else {
                            b(pVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cGr.getText().toString();
            if (this.cFO && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                e.alU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cGr);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cFN || pVar.apk() == EmotionGroupType.LOCAL) {
            String obj = this.cGr.getText().toString();
            if (this.cFO && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                e.alU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cGr);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.cGr != null) {
            this.cGr.setFocusable(true);
            this.cGr.setFocusableInTouchMode(true);
            this.cGr.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), this.cGr);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.csg = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.cGr, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.cGr, R.drawable.edittext_cursor);
            this.cGr.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.cGr, R.drawable.edittext_cursor_1);
            this.cGr.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cwD();
        am.setImageResource(this.fxv, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwD() {
        if (this.asQ.isEnabled()) {
            am.setViewTextColor(this.asQ, R.color.cp_link_tip_a, 1, this.csg);
        } else {
            am.setViewTextColor(this.asQ, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.cGr;
    }
}
