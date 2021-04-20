package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.z0.i0;
import java.util.List;
/* loaded from: classes5.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22295a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f22296b;

    /* renamed from: d  reason: collision with root package name */
    public f f22298d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22297c = false;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f22299e = new a(this);

    /* loaded from: classes5.dex */
    public class a implements TextView.OnEditorActionListener {
        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            View focusSearch;
            if (i != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                return true;
            }
            focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22300e;

        public b(int i) {
            this.f22300e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22298d != null) {
                WriteVoteViewAdapter.this.f22298d.a(this.f22300e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22298d != null) {
                WriteVoteViewAdapter.this.f22298d.b();
                WriteVoteViewAdapter.this.f22297c = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22303a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22304b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f22305c;

        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f22303a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f22304b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f22305c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EditText f22306a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22307b;

        /* renamed from: c  reason: collision with root package name */
        public g f22308c;

        /* loaded from: classes5.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e eVar = e.this;
                    eVar.f22306a.addTextChangedListener(eVar.f22308c);
                    return;
                }
                e eVar2 = e.this;
                eVar2.f22306a.removeTextChangedListener(eVar2.f22308c);
            }
        }

        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f22306a = (EditText) view.findViewById(R.id.vote_item);
            this.f22307b = (ImageView) view.findViewById(R.id.img_delete);
            this.f22308c = new g(this);
            this.f22306a.setOnEditorActionListener(writeVoteViewAdapter.f22299e);
        }

        public void b(int i) {
            this.f22308c.a(i);
            this.f22306a.setOnFocusChangeListener(new a());
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i);
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final e f22310e;

        /* renamed from: f  reason: collision with root package name */
        public int f22311f;

        public g(e eVar) {
            this.f22310e = eVar;
        }

        public void a(int i) {
            this.f22311f = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f22311f + 1);
            if (i0.d(replace) > 28) {
                WriteVoteViewAdapter.this.f22295a.showToast(String.format(WriteVoteViewAdapter.this.f22295a.getString(R.string.write_vote_toast), 14));
            }
            String m = i0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f22310e.f22306a.setText(m);
                this.f22310e.f22306a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            WriteVoteViewAdapter.this.f22298d.c(writeVoteItemData, this.f22311f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        this.f22295a = tbPageContext;
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f22295a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f22295a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f22306a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f22306a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f22306a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f22307b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f22303a, R.color.CAM_X0302);
            dVar.f22305c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f22304b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void g(f fVar) {
        this.f22298d = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WriteVoteItemData> list = this.f22296b;
        if (list == null) {
            return 0;
        }
        if (list.size() < 20) {
            return this.f22296b.size() + 1;
        }
        return 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return !h(i) ? 1 : 2;
    }

    public final boolean h(int i) {
        List<WriteVoteItemData> list = this.f22296b;
        return list != null && list.size() < 20 && i == this.f22296b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            String text = this.f22296b.get(i).getText();
            eVar.f22306a.setHint(String.format(this.f22295a.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            eVar.f22306a.setGravity(19);
            if (i < this.f22296b.size() - 1) {
                eVar.f22306a.setImeOptions(5);
            } else {
                eVar.f22306a.setImeOptions(1);
            }
            ImageView imageView = eVar.f22307b;
            if (this.f22296b.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new b(i));
            eVar.b(i);
            if (!StringUtils.isNull(text)) {
                eVar.f22306a.setText(text);
            } else {
                eVar.f22306a.setText("");
            }
            if (this.f22297c && i == this.f22296b.size() - 1) {
                eVar.f22306a.requestFocus();
                this.f22297c = false;
            }
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            dVar.f22303a.setText(String.format(this.f22295a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f22296b.size())));
            dVar.f22305c.setOnClickListener(new c());
        }
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new e(this, LayoutInflater.from(this.f22295a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(this.f22295a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    public void setData(List<WriteVoteItemData> list) {
        this.f22296b = list;
        notifyDataSetChanged();
    }
}
