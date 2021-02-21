package com.bytedance.sdk.openadsdk.d.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final Type[] f6925a = new Type[0];

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new C1017b(type, type2, typeArr);
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static WildcardType b(Type type) {
        return new c(type instanceof WildcardType ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f6925a);
    }

    public static WildcardType c(Type type) {
        return new c(new Type[]{Object.class}, type instanceof WildcardType ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(d(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C1017b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
            return type;
        }
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            com.bytedance.sdk.openadsdk.d.b.a.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return e(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                if (!a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                    z = false;
                }
                return z;
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                    z = false;
                }
                return z;
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                z = false;
            }
            return z;
        } else {
            return false;
        }
    }

    static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return type;
    }

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        com.bytedance.sdk.openadsdk.d.b.a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type g(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type a(Type type, Class<?> cls) {
        Type b2 = b(type, cls, Collection.class);
        if (b2 instanceof WildcardType) {
            b2 = ((WildcardType) b2).getUpperBounds()[0];
        }
        return b2 instanceof ParameterizedType ? ((ParameterizedType) b2).getActualTypeArguments()[0] : Object.class;
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b2 = b(type, cls, Map.class);
        return b2 instanceof ParameterizedType ? ((ParameterizedType) b2).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    private static Type a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type a2;
        Type[] typeArr;
        boolean z;
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            if (!collection.contains(typeVariable)) {
                collection.add(typeVariable);
                type3 = a(type, cls, (TypeVariable<?>) typeVariable);
                if (type3 == typeVariable) {
                    return type3;
                }
            } else {
                return type3;
            }
        }
        if ((type3 instanceof Class) && ((Class) type3).isArray()) {
            Class cls2 = (Class) type3;
            Class<?> componentType = cls2.getComponentType();
            Type a3 = a(type, cls, componentType, collection);
            if (componentType != a3) {
                return a(a3);
            }
            return cls2;
        } else if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type a4 = a(type, cls, genericComponentType, collection);
            if (genericComponentType != a4) {
                return a(a4);
            }
            return genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type a5 = a(type, cls, ownerType, collection);
            boolean z2 = a5 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            int i = 0;
            boolean z3 = z2;
            while (i < length) {
                Type a6 = a(type, cls, actualTypeArguments[i], collection);
                if (a6 != actualTypeArguments[i]) {
                    if (z3) {
                        typeArr = actualTypeArguments;
                        z = z3;
                    } else {
                        typeArr = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    typeArr[i] = a6;
                } else {
                    typeArr = actualTypeArguments;
                    z = z3;
                }
                i++;
                actualTypeArguments = typeArr;
                z3 = z;
            }
            if (z3) {
                return a(a5, parameterizedType.getRawType(), actualTypeArguments);
            }
            return parameterizedType;
        } else if (type3 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type a7 = a(type, cls, lowerBounds[0], collection);
                if (a7 != lowerBounds[0]) {
                    return c(a7);
                }
                return wildcardType;
            } else if (upperBounds.length == 1 && (a2 = a(type, cls, upperBounds[0], collection)) != upperBounds[0]) {
                return b(a2);
            } else {
                return wildcardType;
            }
        } else {
            return type3;
        }
    }

    static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a2 = a(typeVariable);
        if (a2 != null) {
            Type a3 = a(type, cls, a2);
            if (a3 instanceof ParameterizedType) {
                return ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)];
            }
            return typeVariable;
        }
        return typeVariable;
    }

    private static int a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void h(Type type) {
        com.bytedance.sdk.openadsdk.d.b.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1017b implements Serializable, ParameterizedType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f6928a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f6929b;
        private final Type[] c;

        public C1017b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                com.bytedance.sdk.openadsdk.d.b.a.a(type != null || (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null));
            }
            this.f6928a = type == null ? null : b.d(type);
            this.f6929b = b.d(type2);
            this.c = (Type[]) typeArr.clone();
            int length = this.c.length;
            for (int i = 0; i < length; i++) {
                com.bytedance.sdk.openadsdk.d.b.a.a(this.c[i]);
                b.h(this.c[i]);
                this.c[i] = b.d(this.c[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f6929b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f6928a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.a((Type) this, (Type) ((ParameterizedType) obj));
        }

        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.f6929b.hashCode()) ^ b.a((Object) this.f6928a);
        }

        public String toString() {
            int length = this.c.length;
            if (length == 0) {
                return b.f(this.f6929b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(b.f(this.f6929b)).append("<").append(b.f(this.c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ").append(b.f(this.c[i]));
            }
            return sb.append(">").toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a implements Serializable, GenericArrayType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f6926a;

        public a(Type type) {
            this.f6926a = b.d(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f6926a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.a((Type) this, (Type) ((GenericArrayType) obj));
        }

        public int hashCode() {
            return this.f6926a.hashCode();
        }

        public String toString() {
            return b.f(this.f6926a) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c implements Serializable, WildcardType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f6932a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f6933b;

        public c(Type[] typeArr, Type[] typeArr2) {
            com.bytedance.sdk.openadsdk.d.b.a.a(typeArr2.length <= 1);
            com.bytedance.sdk.openadsdk.d.b.a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                com.bytedance.sdk.openadsdk.d.b.a.a(typeArr2[0]);
                b.h(typeArr2[0]);
                com.bytedance.sdk.openadsdk.d.b.a.a(typeArr[0] == Object.class);
                this.f6933b = b.d(typeArr2[0]);
                this.f6932a = Object.class;
                return;
            }
            com.bytedance.sdk.openadsdk.d.b.a.a(typeArr[0]);
            b.h(typeArr[0]);
            this.f6933b = null;
            this.f6932a = b.d(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f6932a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return this.f6933b != null ? new Type[]{this.f6933b} : b.f6925a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.a((Type) this, (Type) ((WildcardType) obj));
        }

        public int hashCode() {
            return (this.f6933b != null ? this.f6933b.hashCode() + 31 : 1) ^ (this.f6932a.hashCode() + 31);
        }

        public String toString() {
            if (this.f6933b != null) {
                return "? super " + b.f(this.f6933b);
            }
            if (this.f6932a == Object.class) {
                return "?";
            }
            return "? extends " + b.f(this.f6932a);
        }
    }
}
