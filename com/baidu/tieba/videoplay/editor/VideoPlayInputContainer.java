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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes11.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools Zd;
    private int Ze;
    private int afW;
    private TextView bbQ;
    private EditText dYP;
    private LinearLayout dYT;
    private boolean dYl;
    private boolean dYm;
    private boolean dYn;
    private int dYo;
    private ImageView hbt;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYl = false;
        this.dYm = true;
        this.dYn = true;
        this.dYo = -1;
        this.afW = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.dYT = new LinearLayout(getContext());
        this.dYT.setOrientation(0);
        this.dYT.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dYT, new LinearLayout.LayoutParams(-1, -2));
        fg(context);
        dA(context);
        dz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fg(Context context) {
        this.hbt = new ImageView(context);
        this.hbt.setEnabled(true);
        this.hbt.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.dYT.addView(this.hbt, layoutParams);
    }

    private void dA(Context context) {
        this.dYP = new EditText(context);
        this.dYP.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYP.setMaxLines(4);
        this.dYP.setGravity(16);
        this.dYP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYP.setBackgroundResource(R.color.common_color_10022);
        e(this.dYP, R.drawable.edittext_cursor);
        this.dYP.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dYP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dYP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.dYn) {
                    VideoPlayInputContainer.this.dYn = true;
                    if (VideoPlayInputContainer.this.dYo != -1) {
                        VideoPlayInputContainer.this.dYP.setSelection(VideoPlayInputContainer.this.dYo);
                        VideoPlayInputContainer.this.dYo = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.dYP.getText().toString()));
                }
                VideoPlayInputContainer.this.bbQ.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.der();
            }
        });
        this.dYP.setHint(context.getString(R.string.reply_something));
        this.dYP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.dYP.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.dYT.addView(this.dYP, layoutParams);
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

    private void dz(Context context) {
        this.bbQ = new TextView(context);
        this.bbQ.setGravity(17);
        this.bbQ.setIncludeFontPadding(false);
        this.bbQ.setEnabled(false);
        this.bbQ.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bbQ.setText(R.string.send_replay);
        this.bbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.dYT.addView(this.bbQ, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dYP.getSelectionStart() > 0) {
                        String substring = this.dYP.getText().toString().substring(0, this.dYP.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gKE.matcher(substring);
                        if (matcher.find()) {
                            this.dYP.getText().delete(this.dYP.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dYP.getSelectionStart());
                            return;
                        }
                        this.dYP.getText().delete(this.dYP.getSelectionStart() - 1, this.dYP.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.dYP.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dYP.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.dYP.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.dYP.setSelection(VideoPlayInputContainer.this.dYP.getText().length());
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
                        this.dYP.setText((CharSequence) null);
                    }
                    this.bbQ.setEnabled(false);
                    der();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.aRV() == EmotionGroupType.NET_SUG) {
                            a(qVar);
                            return;
                        } else {
                            b(qVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dYP.getText().toString();
            if (this.dYm && com.baidu.tieba.face.a.Ch(obj) >= 10 && getContext() != null) {
                e.aOb().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dYP);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dYl || qVar.aRV() == EmotionGroupType.LOCAL) {
            String obj = this.dYP.getText().toString();
            if (this.dYm && com.baidu.tieba.face.a.Ch(obj) >= 10 && getContext() != null) {
                e.aOb().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dYP);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dYP != null) {
            this.dYP.setFocusable(true);
            this.dYP.setFocusableInTouchMode(true);
            this.dYP.requestFocus();
            l.showSoftKeyPad(getContext(), this.dYP);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.afW = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dYP, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dYP, R.drawable.edittext_cursor);
            this.dYP.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.dYP, R.drawable.edittext_cursor_1);
            this.dYP.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        der();
        am.setImageResource(this.hbt, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void der() {
        if (this.bbQ.isEnabled()) {
            am.setViewTextColor(this.bbQ, R.color.cp_link_tip_a, 1, this.afW);
        } else {
            am.setViewTextColor(this.bbQ, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.dYP;
    }
}
