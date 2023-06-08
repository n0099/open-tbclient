package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uu9 extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public LikeModel c;
    public int d;
    public int e;
    public boolean f;
    public ForumDetailActivityConfig.FromType g;
    public ForumInfoData[] h;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;

        public a(uu9 uu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public uu9(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = ForumDetailActivityConfig.FromType.BAR_DIR;
        this.a = tbPageContext;
        this.e = i;
        this.h = new ForumInfoData[0];
    }

    public ForumInfoData[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ForumInfoData[]) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LikeModel likeModel = this.c;
            if (likeModel == null) {
                return false;
            }
            return likeModel.k0();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ForumInfoData[] forumInfoDataArr = this.h;
            if (forumInfoDataArr == null) {
                return 0;
            }
            int i = this.d;
            if (i > forumInfoDataArr.length) {
                return forumInfoDataArr.length;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 100000) {
                return String.valueOf(i / 10000) + this.a.getString(R.string.member_count_unit);
            }
            return String.valueOf(i);
        }
        return (String) invokeI.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
            notifyDataSetChanged();
        }
    }

    public void f(ForumInfoData[] forumInfoDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumInfoDataArr) == null) {
            this.h = forumInfoDataArr;
            if (forumInfoDataArr != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void g(ForumDetailActivityConfig.FromType fromType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fromType) == null) {
            this.g = fromType;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i > this.d) {
                return null;
            }
            return this.h[i];
        }
        return invokeI.objValue;
    }

    public void h(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bool) == null) {
            this.f = bool.booleanValue();
        }
    }

    public void j(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, likeModel) == null) {
            this.c = likeModel;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (view2 == null || view2.getTag() == null) {
                view2 = View.inflate(this.a.getContext(), R.layout.obfuscated_res_0x7f0d02f5, null);
                a aVar = new a(this);
                BarImageView barImageView = (BarImageView) view2.findViewById(R.id.forum_avatar);
                aVar.a = barImageView;
                barImageView.setGifIconSupport(false);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09181e);
                aVar.e = (TextView) view2.findViewById(R.id.member_count);
                aVar.f = (TextView) view2.findViewById(R.id.thread_count);
                aVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09216f);
                aVar.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0914cf);
                aVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d6e);
                aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e80);
                view2.setTag(aVar);
            }
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09037c);
            View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f09037b);
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
            if (i == 0) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            a aVar2 = (a) view2.getTag();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            d05 layoutMode = this.a.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(view2);
            ForumInfoData[] forumInfoDataArr = this.h;
            ForumInfoData forumInfoData = forumInfoDataArr[i];
            String str = forumInfoDataArr[i].avatar;
            aVar2.a.setTag(str);
            aVar2.a.invalidate();
            aVar2.a.N(str, 10, false);
            aVar2.d.setText(forumInfoData.forum_name);
            aVar2.d.setTag(Integer.valueOf(forumInfoData.forum_id));
            aVar2.h.setTag(forumInfoData.forum_name);
            TextView textView = aVar2.e;
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f02e5) + " " + b(forumInfoData.member_count));
            TextView textView2 = aVar2.f;
            textView2.setText(this.a.getString(R.string.text_post) + " " + b(forumInfoData.thread_count));
            aVar2.g.setText(forumInfoData.slogan);
            if (this.e == 0) {
                aVar2.c.setVisibility(8);
                if (!this.f) {
                    aVar2.b.setVisibility(8);
                } else {
                    aVar2.b.setVisibility(0);
                    aVar2.b.setText((CharSequence) null);
                    aVar2.b.setBackgroundDrawable(null);
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                aVar2.b.setText(String.format("%02d", Integer.valueOf(i + 1)));
                            } else {
                                SkinManager.setBackgroundResource(aVar2.b, R.drawable.icon_brief_grade_green);
                            }
                        } else {
                            SkinManager.setBackgroundResource(aVar2.b, R.drawable.icon_brief_grade_blue);
                        }
                    } else {
                        SkinManager.setBackgroundResource(aVar2.b, R.drawable.icon_brief_grade_orange);
                    }
                }
            } else {
                aVar2.b.setVisibility(8);
                aVar2.c.setVisibility(0);
                aVar2.c.setText((CharSequence) null);
                aVar2.c.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
                TextView textView3 = aVar2.c;
                textView3.setText(this.a.getString(R.string.obfuscated_res_0x7f0f121f) + String.valueOf(forumInfoData.mbr_inter_rank) + this.a.getString(R.string.obfuscated_res_0x7f0f0e86));
            }
            aVar2.h.setOnClickListener(this);
            view2.setOnClickListener(this);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) && i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (int i = 0; i < this.d; i++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.h[i].forum_name);
                if (hasLikeForum == 1) {
                    this.h[i].is_like = 1;
                } else if (hasLikeForum == -1) {
                    this.h[i].is_like = 0;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0914cf) {
                TiebaStatic.eventStat(this.a.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg((String) view2.getTag(), null).setCallFrom(5)));
                return;
            }
            a aVar = (a) view2.getTag();
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.getPageActivity(), String.valueOf(aVar.d.getTag()), this.g)));
                return;
            }
            TiebaStatic.eventStat(this.a.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(aVar.d.getText().toString(), null)));
        }
    }
}
