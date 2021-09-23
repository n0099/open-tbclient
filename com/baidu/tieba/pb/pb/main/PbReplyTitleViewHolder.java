package com.baidu.tieba.pb.pb.main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.r0.j2.h.o;
import c.a.r0.j2.k.e.s0;
import c.a.r0.j3.i0.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes7.dex */
public class PbReplyTitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f55323a;

    /* renamed from: b  reason: collision with root package name */
    public View f55324b;

    /* renamed from: c  reason: collision with root package name */
    public View f55325c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55326d;

    /* renamed from: e  reason: collision with root package name */
    public List<TextLineView> f55327e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f55328f;

    /* renamed from: g  reason: collision with root package name */
    public SortSwitchButton.f f55329g;

    /* renamed from: h  reason: collision with root package name */
    public o f55330h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f55331i;
    public boolean isSticky;

    /* renamed from: j  reason: collision with root package name */
    public BdUniqueId f55332j;
    public TbPageContext k;
    public SortSwitchButton.f l;
    public View.OnClickListener m;
    public View mDivideLineBottom;
    public View mDivideLineTop;
    public TextLineView mFloorOwnerView;
    public TextLineView mGodReplyTitle;
    public View mGodReplyTitleGroupView;
    public TextView mGodTitleEntrance;
    public int mSkinType;
    public SortSwitchButton mSortButton;
    public TextLineView mTitleView;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f55333a;

        public a(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55333a = pbReplyTitleViewHolder;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f55333a.f55329g != null) {
                    return this.f55333a.f55329g.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f55334e;

        public c(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55334e = pbReplyTitleViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55334e.f55328f == null) {
                return;
            }
            this.f55334e.f55328f.onClick(this.f55334e.mGodReplyTitleGroupView);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f55335e;

        public d(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55335e = pbReplyTitleViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f55335e.f55328f != null) {
                    this.f55335e.f55328f.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        for (TextLineView textLineView : this.f55335e.f55327e) {
                            if (textLineView != null) {
                                if (textLineView != view) {
                                    textLineView.setSelected(false);
                                } else {
                                    textLineView.setSelected(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f55336a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbReplyTitleViewHolder pbReplyTitleViewHolder, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55336a = pbReplyTitleViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f55336a.f55330h != null && this.f55336a.f55330h.f19666f == o.l && customResponsedMessage != null && getTag() == this.f55336a.f55331i && (customResponsedMessage.getData() instanceof s0.p0)) {
                ((s0.p0) customResponsedMessage.getData()).f20296c = this.f55336a;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f55337a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PbReplyTitleViewHolder pbReplyTitleViewHolder, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55337a = pbReplyTitleViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.f55337a.f55330h == null || this.f55337a.f55330h.f19666f != o.m || customResponsedMessage == null || getTag() != this.f55337a.f55332j || !(customResponsedMessage.getData() instanceof s0.p0)) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
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
        this.mSkinType = 3;
        this.isSticky = true;
        this.l = new a(this);
        this.m = new d(this);
        this.n = new e(this, 2004013);
        this.o = new f(this, 2004013);
        if (view == null) {
            return;
        }
        this.f55323a = view;
        this.k = tbPageContext;
        view.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view.findViewById(R.id.reply_title);
        this.mTitleView = textLineView;
        textLineView.setOnClickListener(this.m);
        this.mGodReplyTitleGroupView = view.findViewById(R.id.reply_god_title_group);
        TextLineView textLineView2 = (TextLineView) view.findViewById(R.id.reply_god_title);
        this.mGodReplyTitle = textLineView2;
        textLineView2.setSelected(false);
        this.f55325c = view.findViewById(R.id.reply_all_title_frame);
        this.f55324b = view.findViewById(R.id.reply_all_title);
        this.f55326d = (TextView) view.findViewById(R.id.reply_title_dynamic);
        TextLineView textLineView3 = (TextLineView) view.findViewById(R.id.floor_owner_reply);
        this.mFloorOwnerView = textLineView3;
        textLineView3.setOnClickListener(this.m);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
        this.mSortButton = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.l);
        this.mSortButton.setVisibility(0);
        this.mGodTitleEntrance = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
        this.mTitleView.setSelected(true);
        this.mFloorOwnerView.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.f55327e = arrayList;
        arrayList.add(this.mTitleView);
        this.f55327e.add(this.mFloorOwnerView);
        this.mDivideLineTop = view.findViewById(R.id.divider_with_reply_title);
        this.mDivideLineBottom = view.findViewById(R.id.divider_bottom);
        this.mSortButton.changeState(2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bindDataToView(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            this.f55330h = oVar;
            if (oVar == null) {
                return;
            }
            BdUniqueId bdUniqueId = oVar.f19666f;
            if (bdUniqueId == o.m) {
                this.mGodReplyTitleGroupView.getContext();
                if (TextUtils.isEmpty(oVar.f19665e)) {
                    this.f55325c.setVisibility(0);
                    this.mGodReplyTitleGroupView.setVisibility(8);
                    this.mTitleView.setVisibility(0);
                    this.mTitleView.setSelected(false);
                    this.mTitleView.setClickable(false);
                    this.mTitleView.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.f55325c.setVisibility(8);
                    this.mTitleView.setVisibility(8);
                    this.mGodReplyTitleGroupView.setVisibility(0);
                    this.mGodReplyTitleGroupView.setOnClickListener(new c(this));
                }
                this.mSortButton.setVisibility(8);
                this.mFloorOwnerView.setVisibility(8);
                this.mDivideLineBottom.setVisibility(8);
            } else if (bdUniqueId == o.l) {
                this.mGodReplyTitleGroupView.setVisibility(8);
                this.f55325c.setVisibility(0);
                this.mTitleView.setClickable(true);
                this.mTitleView.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mFloorOwnerView.setVisibility(0);
                changeHostModeUI(oVar.f19668h);
                if (oVar.k != null) {
                    this.mSortButton.setVisibility(0);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= oVar.k.size()) {
                            i2 = 0;
                            break;
                        } else if (oVar.k.get(i2) != null && oVar.f19667g == oVar.k.get(i2).sort_type.intValue()) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    initSortSwitchButton(oVar.k, i2);
                }
                this.mDivideLineBottom.setVisibility(0);
            }
            if (this.isSticky) {
                this.mDivideLineBottom.getLayoutParams().height = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                SkinManager.setBackgroundColor(this.f55325c, R.color.CAM_X0207);
            } else {
                this.mDivideLineBottom.getLayoutParams().height = 0;
                SkinManager.setBackgroundColor(this.f55325c, R.color.CAM_X0205);
            }
            if (oVar.f19669i) {
                this.f55326d.setVisibility(0);
                this.f55324b.setVisibility(8);
            } else {
                this.f55326d.setVisibility(8);
                this.f55324b.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void changeHostModeUI(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.mFloorOwnerView.setSelected(true);
                this.mTitleView.setSelected(false);
                return;
            }
            this.mFloorOwnerView.setSelected(false);
            this.mTitleView.setSelected(true);
        }
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55323a : (View) invokeV.objValue;
    }

    public void initSortSwitchButton(List<PbSortType> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (ListUtils.isEmpty(list)) {
                this.mSortButton.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.mSortButton.setVisibility(0);
            this.mSortButton.setData(arrayList, i2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (this.mSkinType != i2) {
                SkinManager.setBackgroundColor(this.f55325c, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.mGodReplyTitleGroupView, R.color.CAM_X0201);
                this.mTitleView.onChangeSkinType(i2);
                this.mFloorOwnerView.onChangeSkinType(i2);
                SkinManager.setViewTextColor(this.mGodReplyTitle, R.color.CAM_X0105);
                o oVar = this.f55330h;
                if (oVar != null && oVar.f19666f == o.m) {
                    SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0107, 1);
                }
                SkinManager.setViewTextColor(this.mGodTitleEntrance, R.color.CAM_X0107);
                this.mGodTitleEntrance.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
                this.mSortButton.onChangeSkinType();
                SkinManager.setBackgroundColor(this.mDivideLineTop, R.color.CAM_X0204);
                if (this.isSticky) {
                    SkinManager.setBackgroundColor(this.mDivideLineBottom, R.color.CAM_X0203);
                    SkinManager.setBackgroundColor(this.f55325c, R.color.CAM_X0207);
                } else {
                    SkinManager.setBackgroundColor(this.f55325c, R.color.CAM_X0205);
                }
                SkinManager.setViewTextColor(this.f55326d, R.color.CAM_X0105, 1);
            }
            this.mSkinType = i2;
        }
    }

    public void registerGodReplyTitleListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.f55332j = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.o.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f55331i = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.n.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void setOnSwitchChangeListener(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.f55329g = fVar;
        }
    }

    public void setPbCommonOnclickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.f55328f = onClickListener;
        }
    }

    public void setSortButtonId(BdUniqueId bdUniqueId) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || (sortSwitchButton = this.mSortButton) == null) {
            return;
        }
        sortSwitchButton.setListenerTag(bdUniqueId);
        this.mSortButton.setCommenId(bdUniqueId);
    }

    public void setViewVisibility(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (view = this.f55323a) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void showRecomStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.f55326d.setText(R.string.hot_recommendation);
                this.f55326d.setTypeface(Typeface.defaultFromStyle(1));
                this.f55326d.setTextSize(0, l.g(this.k.getPageActivity(), R.dimen.T_X07));
                this.f55326d.setVisibility(0);
                this.f55324b.setVisibility(8);
                return;
            }
            this.f55326d.setVisibility(8);
            this.f55324b.setVisibility(0);
            this.f55326d.setTypeface(Typeface.defaultFromStyle(0));
            this.f55326d.setTextSize(0, l.g(this.k.getPageActivity(), R.dimen.tbfontsize42));
        }
    }
}
