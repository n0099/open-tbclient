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
    private EditorTools Dl;
    private int Dm;
    private TextView ati;
    private boolean cGE;
    private boolean cGF;
    private boolean cGG;
    private int cGH;
    private EditText cHi;
    private LinearLayout cHm;
    private int csX;
    private ImageView fym;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGE = false;
        this.cGF = true;
        this.cGG = true;
        this.cGH = -1;
        this.csX = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.cHm = new LinearLayout(getContext());
        this.cHm.setOrientation(0);
        this.cHm.setMinimumHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds90));
        addView(this.cHm, new LinearLayout.LayoutParams(-1, -2));
        ei(context);
        cA(context);
        cz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ei(Context context) {
        this.fym = new ImageView(context);
        this.fym.setEnabled(true);
        this.fym.setPadding(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds30), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24));
        this.fym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.cHm.addView(this.fym, layoutParams);
    }

    private void cA(Context context) {
        this.cHi = new EditText(context);
        this.cHi.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cHi.setMaxLines(4);
        this.cHi.setGravity(16);
        this.cHi.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cHi.setBackgroundResource(R.color.common_color_10022);
        e(this.cHi, R.drawable.edittext_cursor);
        this.cHi.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds54), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24));
        this.cHi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cHi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.cGG) {
                    VideoPlayInputContainer.this.cGG = true;
                    if (VideoPlayInputContainer.this.cGH != -1) {
                        VideoPlayInputContainer.this.cHi.setSelection(VideoPlayInputContainer.this.cGH);
                        VideoPlayInputContainer.this.cGH = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.cHi.getText().toString()));
                }
                VideoPlayInputContainer.this.ati.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cwF();
            }
        });
        this.cHi.setHint(context.getString(R.string.reply_something));
        this.cHi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.cHi.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.cHm.addView(this.cHi, layoutParams);
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
        this.ati = new TextView(context);
        this.ati.setGravity(17);
        this.ati.setIncludeFontPadding(false);
        this.ati.setEnabled(false);
        this.ati.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.ati.setText(R.string.replay);
        this.ati.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.cHm.addView(this.ati, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cHi.getSelectionStart() > 0) {
                        String substring = this.cHi.getText().toString().substring(0, this.cHi.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fhw.matcher(substring);
                        if (matcher.find()) {
                            this.cHi.getText().delete(this.cHi.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cHi.getSelectionStart());
                            return;
                        }
                        this.cHi.getText().delete(this.cHi.getSelectionStart() - 1, this.cHi.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.cHi.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cHi.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.cHi.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.cHi.setSelection(VideoPlayInputContainer.this.cHi.getText().length());
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
                        this.cHi.setText((CharSequence) null);
                    }
                    this.ati.setEnabled(false);
                    cwF();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.apm() == EmotionGroupType.NET_SUG) {
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
            String obj = this.cHi.getText().toString();
            if (this.cGF && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                e.alW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cHi);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cGE || pVar.apm() == EmotionGroupType.LOCAL) {
            String obj = this.cHi.getText().toString();
            if (this.cGF && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                e.alW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cHi);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.cHi != null) {
            this.cHi.setFocusable(true);
            this.cHi.setFocusableInTouchMode(true);
            this.cHi.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), this.cHi);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.csX = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.cHi, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.cHi, R.drawable.edittext_cursor);
            this.cHi.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.cHi, R.drawable.edittext_cursor_1);
            this.cHi.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cwF();
        am.setImageResource(this.fym, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwF() {
        if (this.ati.isEnabled()) {
            am.setViewTextColor(this.ati, R.color.cp_link_tip_a, 1, this.csX);
        } else {
            am.setViewTextColor(this.ati, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.cHi;
    }
}
