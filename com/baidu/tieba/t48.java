package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t48 extends w48<ForumData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;
    public LinearLayout n;
    public BarImageView o;
    public TextView p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t48(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
        q(context);
    }

    @Override // com.baidu.tieba.p48
    public void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ForumData forumData = (ForumData) this.j;
            long userIdLong = this.k.getUserIdLong();
            String userName = this.k.getUserName();
            String name_show = this.k.getName_show();
            String portrait = this.k.getPortrait();
            if (this.k.getIsMyFriend() == 1) {
                z = true;
            } else {
                z = false;
            }
            w58.a(forumData, str, userIdLong, userName, name_show, portrait, z);
            p(1, 0, 3, String.valueOf(this.k.getUserIdLong()));
        }
    }

    @Override // com.baidu.tieba.p48
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            w58.h(str, this.k.groupData, (ForumData) this.j);
        }
    }

    @Override // com.baidu.tieba.w48
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.g();
            p45 d = p45.d(this.n);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0207);
            p45 d2 = p45.d(this.p);
            d2.w(R.color.CAM_X0105);
            d2.C(R.string.F_X02);
            p45.d(this.q).w(R.color.CAM_X0107);
            p45.d(this.r).w(R.color.CAM_X0109);
            p45.d(this.s).w(R.color.CAM_X0109);
            this.o.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.im_share_dialog_forum, i());
            this.n = (LinearLayout) inflate.findViewById(R.id.im_share_forum_info_container);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.im_share_forum_info_head);
            this.o = barImageView;
            barImageView.setPlaceHolder(1);
            this.o.setShowOval(true);
            this.o.setAutoChangeStyle(true);
            this.o.setShowInnerBorder(true);
            this.o.setStrokeWith(ri.g(TbadkCoreApplication.getInst(), R.dimen.L_X01));
            this.o.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.p = (TextView) inflate.findViewById(R.id.im_share_forum_info_title);
            this.q = (EMTextView) inflate.findViewById(R.id.im_share_forum_info_brief);
            this.r = (EMTextView) inflate.findViewById(R.id.im_share_forum_info_attention_count);
            this.s = (EMTextView) inflate.findViewById(R.id.im_share_forum_info_thread_count);
            g();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w48
    /* renamed from: r */
    public void o(ForumData forumData, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, forumData, metaData) == null) {
            super.o(forumData, metaData);
            if (forumData != null && !TextUtils.isEmpty(forumData.getId())) {
                this.o.N(forumData.getImage_url(), 10, false);
                this.p.setText("" + forumData.getName() + this.m.getResources().getString(R.string.obfuscated_res_0x7f0f0730));
                if (!TextUtils.isEmpty(forumData.getSlogan())) {
                    this.q.setVisibility(0);
                    this.q.setText(forumData.getSlogan());
                } else {
                    this.q.setVisibility(8);
                }
                this.r.setText(String.format(this.m.getString(R.string.obfuscated_res_0x7f0f04a6), StringHelper.numberUniformFormatExtra(forumData.getMember_num())));
                this.s.setText(String.format(this.m.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(forumData.getThread_num())));
            }
        }
    }
}
