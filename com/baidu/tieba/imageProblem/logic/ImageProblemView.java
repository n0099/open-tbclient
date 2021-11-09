package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import b.a.e.a.d;
import b.a.e.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class ImageProblemView extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageProblemActivity f50939a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f50940b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f50941c;

    /* renamed from: d  reason: collision with root package name */
    public View f50942d;

    /* renamed from: e  reason: collision with root package name */
    public Button f50943e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f50944f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageProblemActivity, imageProblemAssistant};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50939a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f50942d = this.f50939a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f50939a.findViewById(R.id.view_navigation_bar);
        this.f50940b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f50940b.setTitleText(this.f50939a.getPageContext().getString(R.string.image_problem));
        this.f50941c = (ScrollView) this.f50939a.findViewById(R.id.scrollView);
        Button button = (Button) this.f50939a.findViewById(R.id.check_btn);
        this.f50943e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f50939a.getPageContext().getPageActivity());
        this.f50944f = linearLayout;
        linearLayout.setOrientation(1);
        this.f50941c.addView(this.f50944f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f50934d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f50939a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f50936a);
            this.f50944f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = 0; i2 < this.f50944f.getChildCount(); i2++) {
                View childAt = this.f50944f.getChildAt(i2);
                if (childAt instanceof ImageProblemItemView) {
                    ((ImageProblemItemView) childAt).setStatus(1);
                }
            }
        }
    }

    public Button getCheckButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50943e : (Button) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f50939a.getLayoutMode().k(i2 == 1);
            this.f50939a.getLayoutMode().j(this.f50942d);
            this.f50940b.onChangeSkinType(getPageContext(), i2);
        }
    }

    public void setValue(int i2, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, arrayList) == null) {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                View childAt = this.f50944f.getChildAt(i3);
                if (childAt instanceof ImageProblemItemView) {
                    ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                    imageProblemItemView.setStatus(1);
                    imageProblemItemView.displayArrow();
                    if (arrayList.get(i3).f50937b == 0) {
                        imageProblemItemView.setHelpText("");
                        imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                    } else {
                        imageProblemItemView.setHelpText(arrayList.get(i3).f50938c);
                        imageProblemItemView.setArrowImg(R.drawable.icon_error);
                    }
                }
            }
            if (i2 < this.f50944f.getChildCount()) {
                View childAt2 = this.f50944f.getChildAt(i2);
                if (childAt2 instanceof ImageProblemItemView) {
                    ((ImageProblemItemView) childAt2).setStatus(2);
                }
            }
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i2 = 0; i2 < this.f50944f.getChildCount(); i2++) {
                View childAt = this.f50944f.getChildAt(i2);
                if (childAt instanceof ImageProblemItemView) {
                    ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                    imageProblemItemView.setStatus(3);
                    imageProblemItemView.hideArrow();
                    imageProblemItemView.setHelpText("");
                }
            }
        }
    }
}
