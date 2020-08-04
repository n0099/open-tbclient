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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes18.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools ZS;
    private int ZT;
    private int aho;
    private TextView boO;
    private boolean eBD;
    private boolean eBE;
    private boolean eBF;
    private int eBG;
    private EditText eCh;
    private LinearLayout eCl;
    private ImageView hIZ;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBD = false;
        this.eBE = true;
        this.eBF = true;
        this.eBG = -1;
        this.aho = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.eCl = new LinearLayout(getContext());
        this.eCl.setOrientation(0);
        this.eCl.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.eCl, new LinearLayout.LayoutParams(-1, -2));
        fy(context);
        dX(context);
        dW(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fy(Context context) {
        this.hIZ = new ImageView(context);
        this.hIZ.setEnabled(true);
        this.hIZ.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hIZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.eCl.addView(this.hIZ, layoutParams);
    }

    private void dX(Context context) {
        this.eCh = new EditText(context);
        this.eCh.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eCh.setMaxLines(4);
        this.eCh.setGravity(16);
        this.eCh.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eCh.setBackgroundResource(R.color.common_color_10022);
        e(this.eCh, R.drawable.edittext_cursor);
        this.eCh.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.eCh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eCh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.eBF) {
                    VideoPlayInputContainer.this.eBF = true;
                    if (VideoPlayInputContainer.this.eBG != -1) {
                        VideoPlayInputContainer.this.eCh.setSelection(VideoPlayInputContainer.this.eBG);
                        VideoPlayInputContainer.this.eBG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.eCh.getText().toString()));
                }
                VideoPlayInputContainer.this.boO.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dtv();
            }
        });
        this.eCh.setHint(context.getString(R.string.reply_something));
        this.eCh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.eCh.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.eCl.addView(this.eCh, layoutParams);
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

    private void dW(Context context) {
        this.boO = new TextView(context);
        this.boO.setGravity(17);
        this.boO.setIncludeFontPadding(false);
        this.boO.setEnabled(false);
        this.boO.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.boO.setText(R.string.send_replay);
        this.boO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.eCl.addView(this.boO, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eCh.getSelectionStart() > 0) {
                        String substring = this.eCh.getText().toString().substring(0, this.eCh.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hrz.matcher(substring);
                        if (matcher.find()) {
                            this.eCh.getText().delete(this.eCh.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eCh.getSelectionStart());
                            return;
                        }
                        this.eCh.getText().delete(this.eCh.getSelectionStart() - 1, this.eCh.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.eCh.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eCh.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.eCh.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.eCh.setSelection(VideoPlayInputContainer.this.eCh.getText().length());
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
                        this.eCh.setText((CharSequence) null);
                    }
                    this.boO.setEnabled(false);
                    dtv();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.bef() == EmotionGroupType.NET_SUG) {
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
            String obj = this.eCh.getText().toString();
            if (this.eBE && com.baidu.tieba.face.a.Fc(obj) >= 10 && getContext() != null) {
                e.aZX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.eCh);
            }
        }
    }

    private void b(q qVar) {
        if (!this.eBD || qVar.bef() == EmotionGroupType.LOCAL) {
            String obj = this.eCh.getText().toString();
            if (this.eBE && com.baidu.tieba.face.a.Fc(obj) >= 10 && getContext() != null) {
                e.aZX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.eCh);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.eCh != null) {
            this.eCh.setFocusable(true);
            this.eCh.setFocusableInTouchMode(true);
            this.eCh.requestFocus();
            l.showSoftKeyPad(getContext(), this.eCh);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.aho = i;
        ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.eCh, R.color.cp_cont_f, 2, i);
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.eCh, R.drawable.edittext_cursor);
            this.eCh.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.eCh, R.drawable.edittext_cursor_1);
            this.eCh.setHintTextColor(ao.getColor(i, R.color.cp_cont_d));
        }
        dtv();
        ao.setImageResource(this.hIZ, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtv() {
        if (this.boO.isEnabled()) {
            ao.setViewTextColor(this.boO, R.color.cp_link_tip_a, 1, this.aho);
        } else {
            ao.setViewTextColor(this.boO, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.eCh;
    }
}
