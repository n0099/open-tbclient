package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.f05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class rlb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public RelativeLayout b;
    public VoteView c;
    public WriteVoteData d;
    public b e;

    /* loaded from: classes8.dex */
    public interface b {
        void a(WriteVoteData writeVoteData);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rlb a;

        /* renamed from: com.baidu.tieba.rlb$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0460a implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0460a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, f05Var) != null) {
                    return;
                }
                this.a.a.d = null;
                this.a.a.i(false);
                f05Var.dismiss();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        public a(rlb rlbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rlbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rlbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                f05 f05Var = new f05(this.a.a.getPageActivity());
                f05Var.setTitle(this.a.a.getString(R.string.obfuscated_res_0x7f0f1896));
                f05Var.setTitleShowCenter(true);
                f05Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f1895));
                f05Var.setMessageShowCenter(true);
                f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f055b, new C0460a(this));
                f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                f05Var.create(this.a.a).show();
            }
        }
    }

    public rlb(TbPageContext<?> tbPageContext, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = relativeLayout;
        VoteView voteView = new VoteView(this.a.getPageActivity());
        this.c = voteView;
        voteView.setPageContext(this.a);
        this.c.setDeleteOnClickListener(new a(this));
        this.c.setVoteViewDeleteVisibility(0);
        this.b.addView(this.c);
        i(false);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c.D(i);
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) && (voteView = this.c) != null && onClickListener != null) {
            voteView.setOnItemClickListener(onClickListener);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) && (voteView = this.c) != null && onClickListener != null) {
            voteView.setOnClickListener(onClickListener);
        }
    }

    public void i(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            RelativeLayout relativeLayout = this.b;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(this.d);
            }
        }
    }

    public WriteVoteData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (WriteVoteData) invokeV.objValue;
    }

    public void h(WriteVoteData writeVoteData) {
        VoteView voteView;
        TbPageContext<?> tbPageContext;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, writeVoteData) == null) && writeVoteData != null && (voteView = this.c) != null) {
            this.d = writeVoteData;
            voteView.setVoteTitle(writeVoteData.getTitle());
            if (this.d.getIs_multi() == 1) {
                tbPageContext = this.a;
                i = R.string.vote_type_multiple;
            } else {
                tbPageContext = this.a;
                i = R.string.vote_type_single;
            }
            String string = tbPageContext.getString(i);
            int expire_type = this.d.getExpire_type();
            if (expire_type > 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(6, expire_type);
                str = String.format(this.a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            } else {
                str = "";
            }
            if (StringUtils.isNull(str)) {
                this.c.setVoteSubContent(string);
            } else {
                VoteView voteView2 = this.c;
                voteView2.setVoteSubContent(string + " · " + str);
            }
            ArrayList arrayList = new ArrayList();
            for (WriteVoteItemData writeVoteItemData : this.d.getOptions()) {
                PollOptionData pollOptionData = new PollOptionData();
                pollOptionData.setId(writeVoteItemData.getId());
                pollOptionData.setText(writeVoteItemData.getText());
                arrayList.add(pollOptionData);
            }
            if (!ListUtils.isEmpty(arrayList)) {
                if (arrayList.size() > 3) {
                    this.c.setData(arrayList.subList(0, 3));
                } else {
                    this.c.setData(arrayList);
                }
            }
        }
    }
}
