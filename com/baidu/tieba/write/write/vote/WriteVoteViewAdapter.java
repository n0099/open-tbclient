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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.b1.j0;
import java.util.List;
/* loaded from: classes4.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23088a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f23089b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23090c;

    /* renamed from: d  reason: collision with root package name */
    public f f23091d;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f23092e;

    /* loaded from: classes4.dex */
    public class a implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            View focusSearch;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                    return true;
                }
                focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f23094f;

        public b(WriteVoteViewAdapter writeVoteViewAdapter, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23094f = writeVoteViewAdapter;
            this.f23093e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23094f.f23091d == null) {
                return;
            }
            this.f23094f.f23091d.a(this.f23093e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f23095e;

        public c(WriteVoteViewAdapter writeVoteViewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23095e = writeVoteViewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23095e.f23091d == null) {
                return;
            }
            this.f23095e.f23091d.b();
            this.f23095e.f23090c = true;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23096a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f23097b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f23098c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23096a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f23097b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f23098c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EditText f23099a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f23100b;

        /* renamed from: c  reason: collision with root package name */
        public g f23101c;

        /* loaded from: classes4.dex */
        public class a implements View.OnFocusChangeListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f23102e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23102e = eVar;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                    if (z) {
                        e eVar = this.f23102e;
                        eVar.f23099a.addTextChangedListener(eVar.f23101c);
                        return;
                    }
                    e eVar2 = this.f23102e;
                    eVar2.f23099a.removeTextChangedListener(eVar2.f23101c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23099a = (EditText) view.findViewById(R.id.vote_item);
            this.f23100b = (ImageView) view.findViewById(R.id.img_delete);
            this.f23101c = new g(writeVoteViewAdapter, this);
            this.f23099a.setOnEditorActionListener(writeVoteViewAdapter.f23092e);
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f23101c.a(i2);
                this.f23099a.setOnFocusChangeListener(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i2);
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final e f23103e;

        /* renamed from: f  reason: collision with root package name */
        public int f23104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f23105g;

        public g(WriteVoteViewAdapter writeVoteViewAdapter, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23105g = writeVoteViewAdapter;
            this.f23103e = eVar;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f23104f = i2;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f23104f + 1);
            if (j0.d(replace) > 28) {
                this.f23105g.f23088a.showToast(String.format(this.f23105g.f23088a.getString(R.string.write_vote_toast), 14));
            }
            String m = j0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f23103e.f23099a.setText(m);
                this.f23103e.f23099a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            this.f23105g.f23091d.c(writeVoteItemData, this.f23104f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23090c = false;
        this.f23092e = new a(this);
        this.f23088a = tbPageContext;
    }

    public void g(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f23088a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f23088a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f23099a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f23099a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f23099a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f23100b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f23096a, R.color.CAM_X0302);
            dVar.f23098c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f23097b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<WriteVoteItemData> list = this.f23089b;
            if (list == null) {
                return 0;
            }
            if (list.size() < 20) {
                return this.f23089b.size() + 1;
            }
            return 20;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? !i(i2) ? 1 : 2 : invokeI.intValue;
    }

    public void h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f23091d = fVar;
        }
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            List<WriteVoteItemData> list = this.f23089b;
            return list != null && list.size() < 20 && i2 == this.f23089b.size();
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i2) == null) {
            if (viewHolder instanceof e) {
                e eVar = (e) viewHolder;
                String text = this.f23089b.get(i2).getText();
                eVar.f23099a.setHint(String.format(this.f23088a.getString(R.string.write_vote_item), Integer.valueOf(i2 + 1)));
                eVar.f23099a.setGravity(19);
                if (i2 < this.f23089b.size() - 1) {
                    eVar.f23099a.setImeOptions(5);
                } else {
                    eVar.f23099a.setImeOptions(1);
                }
                ImageView imageView = eVar.f23100b;
                if (this.f23089b.size() > 2) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                imageView.setOnClickListener(new b(this, i2));
                eVar.b(i2);
                if (!StringUtils.isNull(text)) {
                    eVar.f23099a.setText(text);
                } else {
                    eVar.f23099a.setText("");
                }
                if (this.f23090c && i2 == this.f23089b.size() - 1) {
                    eVar.f23099a.requestFocus();
                    this.f23090c = false;
                }
            } else if (viewHolder instanceof d) {
                d dVar = (d) viewHolder;
                dVar.f23096a.setText(String.format(this.f23088a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f23089b.size())));
                dVar.f23098c.setOnClickListener(new c(this));
            }
            g(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            if (i2 == 1) {
                return new e(this, LayoutInflater.from(this.f23088a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
            }
            return new d(this, LayoutInflater.from(this.f23088a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(List<WriteVoteItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f23089b = list;
            notifyDataSetChanged();
        }
    }
}
